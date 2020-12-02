package demo.pattern.proxy;

import demo.pattern.proxy.cglib.AlipayMethodInterceptor;
import demo.pattern.proxy.cglib.CglibUtil;
import demo.pattern.proxy.impl.CommentPayment;
import demo.pattern.proxy.jdkproxy.AlipayInvocationHandler;
import demo.pattern.proxy.jdkproxy.JdkDynamicProxyUtil;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.InvocationHandler;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:37 2020-11-29
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class ProxyDemo {
    public static void main(String[] args) {
//        ToCPayment toCProxy = new AlipayToC(new ToCPaymentImpl());
//        toCProxy.pay();
//
//        ToBPayment toBPayment = new AlipayToB(new ToBPaymentImpl());
//        toBPayment.pay();

//        /**
//         * ToCPayment 表示用户的实现类，而通过Proxy.newInstance 生成的代理类型，也是ToCPayment的类型
//         * 所以是无感的，用户不知道该InvocationHandler的类型。
//         * 通过动态代理，代理逻辑可以复用,InvocationHandler充当了切面,
//         * 代理对象透明化
//         * 利用注解，将需要被包装的对象进行标注，自动进行包装
//         *
//         * P
//         */
//
//        ToCPayment toCPayment = new ToCPaymentImpl();
//        InvocationHandler handler = new AlipayInvocationHandler(toCPayment);
//        toCPayment = JdkDynamicProxyUtil.newProxyInstance(toCPayment,handler);
//        toCPayment.pay();

        /**
         * 报错，没有实现接口
         */

//        CommentPayment commentPayment = new CommentPayment();
//        InvocationHandler handler = new AlipayInvocationHandler(commentPayment);
//        commentPayment = JdkDynamicProxyUtil.newProxyInstance(commentPayment,handler);
//        commentPayment.pay();

        CommentPayment commentPayment = new CommentPayment();
        MethodInterceptor methodInterceptor = new AlipayMethodInterceptor();
        CommentPayment commentPaymentProxy = CglibUtil.createProxy(commentPayment,methodInterceptor);
        commentPaymentProxy.pay();



    }
}
