package com.cognyte.aspectsexample.aop;

import com.cognyte.aspectsexample.exception.CognyteException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Aspect
public class ExceptionHandlerAspect {

    // Use Value annotation for initialize mail list from property file
    // specific property file defined in other annotation (@PropertySource) which
    // defined in MainConf
    @Value("${support.mails}")
    private String[] mails;

    // Using WeakHashMap to avoid keeping unreferenced Object in memory
    // Otherwise, we could explode our memory with irrelevant exceptions
    // which already handled
    private final Map<CognyteException,Void> exceptions = new WeakHashMap<>();

    // Option 1 Using Around
//    @SneakyThrows()
//    @Around("execution(* com.cognyte.aspectsexample..*.*(..))")
//    public Object handleCognyteExceptions(ProceedingJoinPoint pjp) {
//        try {
//            pjp.proceed();
//        } catch (CognyteException e) {
//            for (String mail: mails) {
//                System.out.printf(
//                        "mail with exception: %s sent to %s%n", e.getMessage(),mail);
//            }
//            throw e;
//        }
//        return null;
//    }

    // Option 2 Using AfterThrows, more elegant, keeping only our logic
    @AfterThrowing(pointcut = "execution(* com.cognyte.aspectsexample..*.*(..))",
            throwing = "ce")
    public void handleCognyteExceptions(CognyteException ce) {
        if(!exceptions.containsKey(ce)) {
            for (String mail : mails) {
                System.out.printf(
                        "mail with exception: %s sent to %s%n", ce.getMessage(), mail);
            }
            exceptions.put(ce,null);
        }
    }
}
