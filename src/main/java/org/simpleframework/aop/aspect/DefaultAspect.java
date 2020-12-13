package org.simpleframework.aop.aspect;

import java.lang.reflect.Method;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 20:15 2020-12-02
 * @ Description： 横切逻辑的骨架
 * @ Modified By：
 * @ Version:
 */
public abstract class DefaultAspect {


    public void before(Class<?> targetClass, Method method,Object[] args) throws Throwable{
        /**
         * create by: zhoule
         * description:
         * create time: 20:20 2020-12-02
         * @param targetClass 被代理类的目标类
         * @param method 被代理的目标方法
         * @param args 被代理的目标方法对应的参数列表
         * @return void
         **/

    }
    public Object afterReturning(Class<?> targetClass,Method method,Object[] args,Object returnValue) throws Throwable{
        /**
         * create by: zhoule
         * description:
         * create time: 20:21 2020-12-02
         * @param targetClass 被代理类的目标类
         * @param method 被代理的目标方法
         * @param args 被代理的目标方法对应的参数列表
         * @param returnValue
         * @return java.lang.Object
         **/

        return returnValue;
    }
    public void afterThrowing(Class<?> targetClass,Method method,Object[] args,Throwable e) throws Throwable {
        /**
         * create by: zhoule
         * description:
         * create time: 20:21 2020-12-02
         * @param targetClass 被代理类的目标类
         * @param method 被代理的目标方法
         * @param args 被代理的目标方法对应的参数列表
         * @param e
         * @return void
         **/

    }
}
