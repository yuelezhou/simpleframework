package org.simpleframework.util;

import java.util.Collection;
import java.util.Map;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:18 2020-09-12
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class ValidationUtil {

    public static boolean isEmpty(String obj){
        return obj == null || "".equals(obj);
    }

    public static boolean isEmpty(Object[] obj){
        return obj == null || obj.length == 0;
    }


    public static boolean isEmpty(Collection<?> obj){
        return obj == null || obj.isEmpty();
    }

    public static boolean isEmpty(Map<?,?> obj){
        return obj == null || obj.isEmpty();
    }
}
