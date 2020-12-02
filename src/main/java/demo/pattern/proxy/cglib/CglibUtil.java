package demo.pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 19:45 2020-12-02
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class CglibUtil {

    public static <T> T createProxy(T targetObject, MethodInterceptor methodInterceptor){

        return (T)Enhancer.create(targetObject.getClass(),methodInterceptor);
    }
}
