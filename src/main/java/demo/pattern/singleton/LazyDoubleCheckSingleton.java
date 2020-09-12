package demo.pattern.singleton;

public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton instance;

    private LazyDoubleCheckSingleton(){}
    public static LazyDoubleCheckSingleton getInstance(){

        //第一次检测
        if (instance == null){
            //同步
            synchronized (LazyDoubleCheckSingleton.class){
                if (instance == null){
                    //memory = allocate();//1.分配对象内存空间
                    //instance(memory);   //2.初始化对象 volatile 保证程序执行器不会进行指令重排,会出现空指针异常
                    //instance = memory;  //3.设置instance指向刚分配的内存地址,此时instance != null
                    instance = new LazyDoubleCheckSingleton();
                }

            }
        }
        return instance;
    }

















}