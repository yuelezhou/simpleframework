package org.simpleframework.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 13:57 2020-12-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class ProxyCreator {

    /**
     * create by: zhoule
     * description: 创建动态代理对象并返回
     * create time: 13:58 2020-12-13
     * @param targetClass 被代理的Class的对象
     * @param methodInterceptor 方法拦截器
     * @return java.lang.Object
     **/
    public static Object createProxy(Class<?> targetClass, MethodInterceptor methodInterceptor){
        return Enhancer.create(targetClass,methodInterceptor);
    }
}
