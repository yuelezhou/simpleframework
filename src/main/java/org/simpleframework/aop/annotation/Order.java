package org.simpleframework.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 20:14 2020-12-02
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Order {
    int value();
}
