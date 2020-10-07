package demo.pattern.callback;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 15:54 2020-10-07
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class CallbackDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {
                System.out.println("我要休息了");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我被回调了");
            }
        });
        thread.start();
        //Thread类是主键,Runable里的run方法就是回调函数
    }
}
