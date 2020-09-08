package demo.pattern.singleton;

public class StarvingSingleton {
    //框架倾向于使用饿汉模式,为什么?//5-5 10:00
    private static final StarvingSingleton starvingSingleton = new StarvingSingleton();

    private StarvingSingleton() {
    }

    public static StarvingSingleton getInstance() {
        return starvingSingleton;
    }

    public static void main(String[] args) {
        System.out.println(StarvingSingleton.getInstance());
        System.out.println(StarvingSingleton.getInstance());
    }
}
