package org.simpleframework.aop;

import org.simpleframework.aop.annotation.Aspect;
import org.simpleframework.aop.annotation.Order;
import org.simpleframework.aop.aspect.AspectInfo;
import org.simpleframework.aop.aspect.DefaultAspect;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 14:02 2020-12-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class AspectWeaver {
    private BeanContainer beanContainer;

    public AspectWeaver(BeanContainer beanContainer) {
        this.beanContainer = BeanContainer.getInstance();
    }

    public void doAop(){
        //1.获取所有的切面类
        Set<Class<?>> aspectSet = beanContainer.getClassesByAnnotation(Aspect.class);
//        AOP1.0
//        //2.将切面类按照不同的织入目标进行切分
//        Map<Class<? extends Annotation>, List<AspectInfo>> categorizedMap = new HashMap<>();
//        if (ValidationUtil.isEmpty(aspectSet)){return;}
//        for (Class<?> aspectClass : aspectSet){
//            if (varifyAspect(aspectClass)){
//                categorizeAspect(categorizedMap,aspectClass);
//            }else {
//                throw new RuntimeException("@Aspect and @Order have not been added to the Aspect class," +
//                        "or Aspect class not extend from DefaultAspect ,or the value in Aspect Tag equals @Aspect");
//            }
//        }
//        //3.按照不同的织入目标分别去按序织入Aspect的逻辑
//        if (ValidationUtil.isEmpty(categorizedMap)){return;}
//        for (Class<? extends Annotation> categroy: categorizedMap.keySet()){
//            weaveByCategory(categroy,categorizedMap.get(categroy));
//        }



//        AOP2.0
        if (ValidationUtil.isEmpty(aspectSet)){
            return;
        }
        //2.拼装AspectInfoList
        List<AspectInfo> aspectInfoList = packAspectInfoList(aspectSet);
        //3.遍历容器里的类
        Set<Class<?>> classSet = beanContainer.getClasses();
        for (Class targetClass : classSet){
            //排除AspectClass自身
            if (targetClass.isAnnotationPresent(Aspect.class)){
                continue;
            }
            //4.粗筛符合条件的Aspect
            List<AspectInfo> roughMatchedAspectList = collectRoughMatchedAspectListForSpecificClass(aspectInfoList,targetClass);
            //5.尝试进行Aspect的织入
            warpIfNecessary(roughMatchedAspectList,targetClass);
        }
    }

    private void warpIfNecessary(List<AspectInfo> roughMatchedAspectList, Class targetClass) {

    }

    private List<AspectInfo> collectRoughMatchedAspectListForSpecificClass(List<AspectInfo> aspectInfoList, Class targetClass) {
        List<AspectInfo> roughMatchedAspectList = new ArrayList<>();
        for (AspectInfo aspectInfo : aspectInfoList){
            if (aspectInfo.getPointcutLocator().roughMatches(targetClass)){
                roughMatchedAspectList.add(aspectInfo);
            }
        }
        return roughMatchedAspectList;
    }

    private List<AspectInfo> packAspectInfoList(Set<Class<?>> aspectSet) {
        List<AspectInfo> aspectInfoList = new ArrayList<>();
        for (Class<?> aspectClass : aspectSet){
            if (varifyAspect(aspectClass)){
                Order orderTag = aspectClass.getAnnotation(Order.class);
                Aspect aspectTag = aspectClass.getAnnotation(Aspect.class);
                DefaultAspect defaultAspect = (DefaultAspect)beanContainer.getBean(aspectClass);
                //初始化表达式定位器
                PointcutLocator pointcutLocator = new PointcutLocator(aspectTag.pointcut());
                AspectInfo aspectInfo = new AspectInfo(orderTag.value(),defaultAspect,pointcutLocator);
                aspectInfoList.add(aspectInfo);
            }else{
                throw new RuntimeException("@Aspect and @Order must be added to the Aspect class,and Aspect class must extend from " +
                        "DefaultAspect");
            }
        }
        return aspectInfoList;
    }

    private void weaveByCategory(Class<? extends Annotation> categroy, List<AspectInfo> aspectInfos) {
        //1.获取被代理类的集合
        Set<Class<?>> classSet = beanContainer.getClassesByAnnotation(categroy);
        if (ValidationUtil.isEmpty(classSet)){return;}
        //2.遍历被代理类，分别为每个被代理类生成动态代理类实例
        for (Class<?> targetClass : classSet){
            AspectListExecutor aspectListExecutor = new AspectListExecutor(targetClass,aspectInfos);
            Object proxyBean = ProxyCreator.createProxy(targetClass,aspectListExecutor);
            beanContainer.addBean(targetClass,proxyBean);
        }
        //3.将动态代理对象实例添加到容器里，取代未被代理前的类实例

    }

    private void categorizeAspect(Map<Class<? extends Annotation>, List<AspectInfo>> categorizedMap, Class<?> aspectClass) {
        Order orderTag = aspectClass.getAnnotation(Order.class);
        Aspect aspectTag = aspectClass.getAnnotation(Aspect.class);
        DefaultAspect aspect = (DefaultAspect)beanContainer.getBean(aspectClass);
        AspectInfo aspectInfo = new AspectInfo(orderTag.value(),aspect);
        if (!categorizedMap.containsKey(aspectTag.value())){
            List<AspectInfo> aspectInfoList =  new ArrayList<>();
            aspectInfoList.add(aspectInfo);
            categorizedMap.put(aspectTag.value(),aspectInfoList);
        } else {
            //如果织入的joinpoint不是第一次出现，则往joinpoint对应的value里添加新的Aspect逻辑
            List<AspectInfo> aspectInfoList = categorizedMap.get(aspectTag.value());
            aspectInfoList.add(aspectInfo);
        }
    }

    private boolean varifyAspect(Class<?> aspectClass) {
        /**
         * create by: zhoule
         * description: 框架中一定要遵守给Aspect类添加@Aspect和@Order标签的规范，同时，必须继承自DefaultAspect.class
         * 此外，@Aspect的属性值不能是他本身
         * create time:  2020-12-13
          * @param aspectClass
         * @return boolean
         **/
        return aspectClass.isAnnotationPresent(Aspect.class) &&
                aspectClass.isAnnotationPresent(Order.class) &&
                DefaultAspect.class.isAssignableFrom(aspectClass) &&
                aspectClass.getAnnotation(Aspect.class).value() != Aspect.class;

    }
}
