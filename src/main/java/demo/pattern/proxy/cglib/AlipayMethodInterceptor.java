package demo.pattern.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 19:41 2020-12-02
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class AlipayMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        beforePay();
        Object result = methodProxy.invokeSuper(o,objects);
        afterPay();
        return result;
    }

    private void afterPay() {
        System.out.println("支付给慕课网");
    }

    private void beforePay() {
        System.out.println("从招行取款");
    }
}
