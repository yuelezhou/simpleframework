package demo.generic;

import java.util.LinkedList;
import java.util.List;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:41 2020-09-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class GenericDemo {
    public static void main(String[] args) {
        List linkedList = new LinkedList();
        linkedList.add("word");
        linkedList.add(1);
        for (int i = 0 ; i < linkedList.size(); i ++){
            String item = (String)linkedList.get(i);
            //没有泛型，编译时没有检查机制，运行时会报错
            System.out.println(item);
        }
    }
}
