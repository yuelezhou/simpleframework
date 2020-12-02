package demo.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 19:10 2020-12-02
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class JdkDynamicProxyUtil {

    public static <T> T newProxyInstance(T targetObject, InvocationHandler handler){
        ClassLoader classLoader = targetObject.getClass().getClassLoader();
        Class<?>[] interfaces = targetObject.getClass().getInterfaces();
        return (T)Proxy.newProxyInstance(classLoader,interfaces,handler);
    }
}
