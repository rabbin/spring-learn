package com.rabbin.application.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {
    @Pointcut("execution(public * com.rabbin.application.controller.*.*(..)) || execution(public * com.rabbin.application.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void before() {
        System.out.println("before advice!");
    }

    @Around("log()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("start around advice!");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("end around advice!");

        return proceed;
    }
}
