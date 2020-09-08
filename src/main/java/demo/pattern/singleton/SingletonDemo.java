package demo.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonDemo {
//    public static void main(String[] args) {
//        System.out.println(StarvingSingleton.getInstance());
//        System.out.println(StarvingSingleton.getInstance());
//        System.out.println(LazyDoubleCheckSingleton.getInstance());
//        System.out.println(LazyDoubleCheckSingleton.getInstance());
//    }
    //5-5 为什么单例模式不安全
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(StarvingSingleton.getInstance());
        System.out.println(StarvingSingleton.getInstance());
        Class clazz = StarvingSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        System.out.println(constructor.newInstance());
    }
}
