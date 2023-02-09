package com.cognyte.firststarter.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Before("execution(* com.cognyte.firststarter..*.validate(..))")
    public void logValidateMethods(JoinPoint jp){
        String className = jp.getTarget().getClass().getName();
        System.out.printf("method of validator %s is working%n", className);
    }

}
