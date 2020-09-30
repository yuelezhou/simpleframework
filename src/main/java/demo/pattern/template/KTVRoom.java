package demo.pattern.template;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 14:25 2020-09-30
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public abstract class KTVRoom {
    public void procedure(){
        openDevice();
        orderSong();
        orderExtra();
        pay();
    }

    //模版自带方法，使用前必须得打开设备
    private void openDevice(){
        System.out.println("打开视频和音响");
    }

    //子类必须实现的方法，必须得选歌
    protected abstract void orderSong();

    //钩子
    protected void orderExtra(){};

    //模版自带方法，用后必须得付款
    private void pay(){
        System.out.println("支付本次消费的账单");
    }
}
