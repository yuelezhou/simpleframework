package org.simpleframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.annotation.Component;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.core.annotation.Repository;
import org.simpleframework.core.annotation.Service;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 14:13 2020-09-12
 * @ Description：
 * @ Modified By：
 * @ Version:
 */


@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {

    /**
     *  存放所有被配置标记的目标对象的Map
     */

    //CAS 和 红黑树 锁的粒度更细，并发性能更好
    private final Map<Class<?>,Object> beanMap = new ConcurrentHashMap();

    /**
     * 加载bean的注解列表
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION =
            Arrays.asList(Component.class, Controller.class, Service.class, Repository.class);


    /**
     * 获取Bean容器实例
     */
    public static BeanContainer getInstance(){
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder{
         HOLDER;

         private BeanContainer instance;

         ContainerHolder() {
             this.instance = new BeanContainer();
         }
    }

    /**
     * 容器是否已经加载过bean
     */
    private boolean loaded = false;

    public boolean isLoaded(){
        return loaded;
    }

    public int size(){
        return beanMap.size();
    }


    /**
     * 扫描加载所有Bean
     */

    public synchronized void loadBeans(String packageName){
        //判断bean容器是否被加载过
        if (isLoaded()){
            log.warn("Bean Container has bean loaded");
            return;
        }
        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        if (ValidationUtil.isEmpty(classSet)) {
            log.warn("extract nothing from packageName:" + packageName);
            return;
        }
        for (Class<?> clazz : classSet){
            for (Class<? extends Annotation> annotation: BEAN_ANNOTATION){
                //如果类上面标记了定义的注解
                if (clazz.isAnnotationPresent(annotation)){
                    //将目标类本身作为键，目标类作为值
                    beanMap.put(clazz,ClassUtil.newInstance(clazz,true));
                }
            }
        }
    }

    /**
     * 添加一个IOC容器管理的对象
     */

    public Object addBean(Class<?> clazz,Object bean){
        return beanMap.put(clazz,bean);
    }

    /**
     * 获得一个IOC容器管理的对象
     */
    public Object removeBean(Class<?> clazz){
        return beanMap.remove(clazz);
    }

    /**
     * 根据class对象获取一个IOC容器的Bean实例
     */
    public Object getBean(Class<?> clazz){
        return beanMap.get(clazz);
    }

    /**
     * Class集合
     */
    public Set<Class<?>> getClasses(){
        return beanMap.keySet();
    }

    /**
     * Bean集合
     */
    public Set<Object> getBeans(){
        return new HashSet<>(beanMap.values());
    }

    /**
     * 获取含有注解的集合
     */
    public Set<Class<?>> getClassesByAnnotation(Class<? extends Annotation> annotation){
        //1.获取beanMap的所有class对象
        Set<Class<?>> keySet = getClasses();
        if (ValidationUtil.isEmpty(keySet)){
            log.warn("nothing in beanMap");
            return null;
        }

        //2.通过注解筛选被注解标记的class对象，并添加到classSet里
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : keySet){
            //类是否有相关的注解标记
            if (clazz.isAnnotationPresent(annotation)){
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }

    /**
     * 通过接口或者父类获取实现类或者子类的Class集合，不包括其本身
     */

    public Set<Class<?>> getClassesBySuper(Class<?> interfaceOrClass){
        //1.获取beanMap的所有class对象
        Set<Class<?>> keySet = getClasses();
        if (ValidationUtil.isEmpty(keySet)){
            log.warn("nothing in beanMap");
            return null;
        }

        //2.判断keySet
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : keySet){
            //类是是否是子类或实现类
            if (interfaceOrClass.isAssignableFrom(clazz) && !clazz.equals(interfaceOrClass)){
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }




}
