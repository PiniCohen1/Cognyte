package com.cognyte.uranium.aspect;

import com.cognyte.uranium.exception.UraniumException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {


//    @After("@annotation(Deprecated)")
//    public void handleDeprecatedMethods(){
//        System.out.println("Avoid using deprecated methods");
//    }

//    execution specific pointcut expression. All methods starts with "enr" prefix,
//    define in any class locate in any package under "com.cognyte"
//    @AfterThrowing(pointcut = "execution(* com.cognyte..*.enr*(..))")

    @Before("@annotation(com.cognyte.uranium.afterinit.Loggable)")
    public void handleLoggableMethods(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName()+" started");
    }

    // Write an aspect which will send an email (don't realy send, just print)
    // to all people which mail appear in mail.properties every time when
    // SupportCognyteException occurred
    // Tip : Check that aspect handle exception only once per exception

    //Solution 1 : Using AfterThrowing
    @AfterThrowing(pointcut = "execution(* com.cognyte..*.*(..))",throwing="ue")
    public void handleSupportCognyteExceptions(UraniumException ue){
        System.out.println("Beware !! UraniumException. Send Emails to supervisors");
    }
}
