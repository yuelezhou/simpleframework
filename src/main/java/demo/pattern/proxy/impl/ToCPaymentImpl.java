package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToCPayment;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:34 2020-11-29
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class ToCPaymentImpl implements ToCPayment {
    @Override
    public void pay() {
        System.out.println("以用户的名义进行支付");
    }
}
