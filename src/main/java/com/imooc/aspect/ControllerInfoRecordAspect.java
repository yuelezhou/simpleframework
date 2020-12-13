package com.imooc.aspect;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.aop.annotation.Aspect;
import org.simpleframework.aop.annotation.Order;
import org.simpleframework.aop.aspect.DefaultAspect;
import org.simpleframework.core.annotation.Controller;

import java.lang.reflect.Method;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:17 2020-12-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Slf4j
@Aspect(value = Controller.class)
@Order(10)
public class ControllerInfoRecordAspect extends DefaultAspect {

    @Override
    public void before(Class<?> targetClass, Method method, Object[] args) throws Throwable {
        log.info("方法开始，执行的类是[{}],执行的方法是[{}],参数是[{}]",targetClass.getName(),method.getName(),args);
    }

    @Override
    public Object afterReturning(Class<?> targetClass, Method method, Object[] args, Object returnValue) throws Throwable {
        log.info("方法结束,执行的类是[{}],执行的方法是[{}],参数是[{}],返回值是[{}]",targetClass.getName(),method.getName(),args,
                returnValue);
        return returnValue;
    }

    @Override
    public void afterThrowing(Class<?> targetClass, Method method, Object[] args, Throwable e) throws Throwable {
        log.info("方法错误,执行的类是[{}],执行的方法是[{}],参数是[{}],异常是[{}]",targetClass.getName(),method.getName(),args,
                e.getMessage());
    }
}
