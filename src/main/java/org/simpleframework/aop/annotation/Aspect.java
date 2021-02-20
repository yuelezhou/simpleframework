package org.simpleframework.aop.annotation;

import java.lang.annotation.*;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 20:11 2020-12-02
 * @ Description：
 * @ Modified By：
 * @ Version:
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
//    Class<? extends Annotation> value();
    String pointcut();
}
