package org.simpleframework.aop;

import lombok.Getter;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.simpleframework.aop.aspect.AspectInfo;
import org.simpleframework.util.ValidationUtil;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 13:28 2020-12-13
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class AspectListExecutor implements MethodInterceptor {

    //被代理的类
    private Class<?> targetClass;

    @Getter
    private List<AspectInfo> sortedAspectInfoList;

    public AspectListExecutor(Class<?> targetClass, List<AspectInfo> aspectInfoList) {
        this.targetClass = targetClass;
        this.sortedAspectInfoList = sortAspectInfoList(aspectInfoList);
    }

    private List<AspectInfo> sortAspectInfoList(List<AspectInfo> aspectInfoList) {
        aspectInfoList.sort(Comparator.comparing(AspectInfo::getOrderIndex));
        return aspectInfoList;
    }

    /**
     * All generated proxied methods call this method instead of the original method.
     * The original method may either be invoked by normal reflection using the Method object,
     * or by using the MethodProxy (faster).
     *
     * @param obj    "this", the enhanced object
     * @param method intercepted Method
     * @param args   argument array; primitive types are wrapped
     * @param proxy  used to invoke super (non-intercepted method); may be called
     *               as many times as needed
     * @return any value compatible with the signature of the proxied method. Method returning void will ignore this value.
     * @throws Throwable any exception may be thrown; if so, super method will not be invoked
     * @see MethodProxy
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object returnValue = null;
        if (ValidationUtil.isEmpty(this.getSortedAspectInfoList()))
            return returnValue;
        try {
            //1.按照order的顺序生序执行完所有Aspect的before方法
            invokeBeforeAdvices(method,args);
            //2.执行被代理类的方法
            returnValue = proxy.invokeSuper(proxy,args);
            //3.如果被代理类方法正常返回，则按照order的顺序降序执行完所有Aspect的afterReturning方法
            returnValue = invokeAfterReturningAdvices(method,args,returnValue);
        } catch (Throwable throwable) {
            //4.如果被代理方法抛出异常，则按照order的顺序降序执行完所有Aspect的afterThrowing方法
            invokeAfterThrowingAdvices(method,args,throwable);
        }
        return returnValue;
    }

    private void invokeAfterThrowingAdvices(Method method, Object[] args, Throwable throwable) throws Throwable {
        for (int i = sortedAspectInfoList.size() -1 ;i >= 0 ; i--){
            sortedAspectInfoList.get(i).getAspectObject().afterThrowing(targetClass,method,args,throwable);
        }
    }

    private Object invokeAfterReturningAdvices(Method method, Object[] args, Object returnValue) throws Throwable {
        Object result = null;
        for (int i = sortedAspectInfoList.size() -1 ;i >= 0 ; i--){
            result = sortedAspectInfoList.get(i).getAspectObject().afterReturning(targetClass,method,args,returnValue);
        }
        return result;
    }

    private void invokeBeforeAdvices(Method method, Object[] args) throws Throwable {
        for (AspectInfo aspectInfo : sortedAspectInfoList){
            aspectInfo.getAspectObject().before(targetClass,method,args);
        }
    }
}
