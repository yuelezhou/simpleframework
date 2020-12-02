package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToBPayment;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:40 2020-11-29
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class ToBPaymentImpl implements ToBPayment {
    @Override
    public void pay() {
        beforePay();
        System.out.println("以公司的名义支付");
        afterPay();
    }

    private void afterPay() {
        System.out.println("支付给慕课网");
    }

    private void beforePay() {
        System.out.println("从招行取款");
    }
}
