package com.cognyte.firststarter.aop;

import com.cognyte.firststarter.exception.CognyteException;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.WeakHashMap;

@Component
@Aspect
public class ExceptionHandlerAspect implements MethodInterceptor {

    @Autowired
    private ExceptionDistributor exceptionDistributor;
    private final Map<CognyteException,Void> exceptions = new WeakHashMap<>();

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            return invocation.proceed();
        } catch (CognyteException ce) {
            if(!exceptions.containsKey(ce)) {
                exceptionDistributor.deliverException(ce);
                exceptions.put(ce, null);
            }
            throw ce;
        }
    }
}
