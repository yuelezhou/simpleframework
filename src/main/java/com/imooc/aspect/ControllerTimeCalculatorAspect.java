package com.imooc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.aop.annotation.Aspect;
import org.simpleframework.aop.annotation.Order;
import org.simpleframework.aop.aspect.DefaultAspect;
import org.simpleframework.core.annotation.Controller;

import java.lang.reflect.Method;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:03 2020-12-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Slf4j
@Aspect(value = Controller.class)
@Order(value = 1)
public class ControllerTimeCalculatorAspect extends DefaultAspect {

    private long timestampCache;

    @Override
    public void before(Class<?> targetClass, Method method, Object[] args) throws Throwable {
        log.info("开始计时，执行的类是[{}],执行的方法是[{}],参数是[{}]",targetClass.getName(),method.getName(),args);
        timestampCache = System.currentTimeMillis();

    }

    @Override
    public Object afterReturning(Class<?> targetClass, Method method, Object[] args, Object returnValue) throws Throwable {
        long endTime = System.currentTimeMillis();
        long costTime = endTime - timestampCache;
        log.info("结束计时,执行的类是[{}],执行的方法是[{}],参数是[{}],返回值是[{}],花费的时间为[{}]",targetClass.getName(),method.getName(),args,
                returnValue,costTime);
        return returnValue;
    }
}
