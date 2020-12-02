package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToCPayment;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:35 2020-11-29
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class AlipayToC implements ToCPayment {

    ToCPayment toCPayment;

    public AlipayToC(ToCPayment toCPayment) {
        this.toCPayment = toCPayment;
    }

    @Override
    public void pay() {
        beforePay();
        toCPayment.pay();
        afterPay();
    }

    private void afterPay() {
        System.out.println("支付给慕课网");
    }

    private void beforePay() {
        System.out.println("从招行取款");
    }
}
