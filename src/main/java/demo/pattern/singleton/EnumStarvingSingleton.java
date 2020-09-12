package demo.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 14:10 2020-09-12
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class EnumStarvingSingleton {
    public EnumStarvingSingleton() {
    }

    public static EnumStarvingSingleton getInstance(){
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder{
        HOLDER;
        private EnumStarvingSingleton instance;
        ContainerHolder() {
            //枚举类型构造器本身就是私有的
            //枚举实例在被加载的时候就被创建出来
            instance = new EnumStarvingSingleton();
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = ContainerHolder.class;
        //Cannot reflectively create enum objects
        Constructor constructor =  clazz.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        System.out.println(EnumStarvingSingleton.getInstance());
        System.out.println(constructor.newInstance());
    }
}
