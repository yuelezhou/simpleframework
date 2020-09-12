package org.simpleframework.inject;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.inject.annotation.Autowired;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 18:29 2020-09-12
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Slf4j
public class DependencyInjector {
    /**
     * Bean容器
     */
    private BeanContainer beanContainer;

    public DependencyInjector(){
        beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行IoC
     */
    public void doIoc(){
        if (ValidationUtil.isEmpty(beanContainer.getClasses())){
            log.warn("empty classSet in BeanContainer");
            return;
        }
        //1.遍历Bean容器中所有的Class对象
        for (Class<?> clazz : beanContainer.getClasses()){
            //2。遍历Class对象的所有成员变量
            Field[] fields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(fields)){
                continue;
            }

            for (Field field : fields){
                //3.找出被Autowired标记的成员变量
                if (field.isAnnotationPresent(Autowired.class)){
                    Autowired autowired = field.getAnnotation(Autowired.class);
                    String autowiredValue = autowired.value();
                    //4。获取这些成员变量的类型
                    Class<?> fieldClass = field.getType();
                    //5。获取这些成员变量的类型在容器里对应的实例
                    Object fieldValue = getFieldInstance(fieldClass,autowiredValue);
                    if (fieldValue == null){
                        throw new RuntimeException("unable to inject relevant type, target fieldClass is:" + fieldClass.getName()
                                + "autowiredValue is:" +  autowiredValue );
                    }else {
                        //6。通过反射将对应的成员变量实例注入到成员变量所在的实例中
                        Object targetBean = beanContainer.getBean(clazz);
                        ClassUtil.setField(field,targetBean,fieldValue,true);
                    }

                }
            }



        }

    }

    private Object getFieldInstance(Class<?> fieldClass,String autowiredValue ) {
        /**
         * create by: zhoule
         * description: 根据Class在beanContainer里获取其实例或者实现类
         * create time: 18:49 2020-09-12
         * @param fieldClass
         * @return java.lang.Object
         **/
        Object fieldValue = beanContainer.getBean(fieldClass);
        if (fieldValue != null){
            return fieldValue;
        } else {
            //其中一种情况是 接口并未被标记@Service注解
            Class<?> implementedClass = getImplementClass(fieldClass,autowiredValue);
            if (implementedClass != null){
                return beanContainer.getBean(implementedClass);
            } else {
                return null;
            }
        }


    }

    private Class<?> getImplementClass(Class<?> fieldClass,String autowiredValue) {
        Set<Class<?>> classSet = beanContainer.getClassesBySuper(fieldClass);
        if (!ValidationUtil.isEmpty(classSet)){
            //有多个实现类 @Qualifier告诉容器使用哪个实现类
            if (ValidationUtil.isEmpty(autowiredValue)){
                if (classSet.size() == 1){
                    return classSet.iterator().next();
                } else {
                    //如果有多个实现类而用户又没有指定一个实现类，则抛出异常
                    throw new RuntimeException("multiple implemented classes for " + fieldClass.getName() + " please set " +
                            "@Autowired's value to pick one");
                }
            } else {
                for (Class<?> clazz : classSet){
                    if (autowiredValue.equals(clazz.getName())){
                        return clazz;
                    }
                }
            }

        }
        return null;
    }
}
