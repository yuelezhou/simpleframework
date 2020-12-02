package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToBPayment;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:42 2020-11-29
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class AlipayToB implements ToBPayment {

    ToBPayment toBPayment;

    public AlipayToB(ToBPayment toBPayment) {
        this.toBPayment = toBPayment;
    }

    @Override
    public void pay() {
        toBPayment.pay();
    }
}
