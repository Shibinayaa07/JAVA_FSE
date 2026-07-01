package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.library.service.*.*(..))")
    public void logBeforeMethod() {
        System.out.println("Method execution started");
    }

    @After("execution(* com.library.service.*.*(..))")
    public void logAfterMethod() {
        System.out.println("Method execution completed");
    }

    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println(joinPoint.getSignature().getName() + " executed in " + (endTime - startTime) + " ms");
        return result;
    }
}
