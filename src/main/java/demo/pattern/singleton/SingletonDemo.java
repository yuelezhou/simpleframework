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
//        System.out.println(StarvingSingleton.getInstance());
//        System.out.println(StarvingSingleton.getInstance());
//        Class clazz = StarvingSingleton.class;
//        Constructor constructor = clazz.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        System.out.println(constructor.newInstance());

        //5-6 4:15
        System.out.println(EnumStarvingSingleton.getInstance());
        System.out.println(EnumStarvingSingleton.getInstance());
        Class clazz = EnumStarvingSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        EnumStarvingSingleton enumStarvingSingleton = (EnumStarvingSingleton)constructor.newInstance();
        //ide不提示 实例使用静态方法，认为冗余
        System.out.println(enumStarvingSingleton.getInstance());


    }
}
