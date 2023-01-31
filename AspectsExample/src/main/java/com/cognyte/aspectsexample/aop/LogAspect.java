package com.cognyte.aspectsexample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspect {

    @Before("execution(* com.cognyte.aspectsexample..*.validate(..))")
    public void logValidateMethods(JoinPoint jp){
        String className = jp.getTarget().getClass().getName();
        System.out.printf("method of validator %s is working%n", className);
    }

}
