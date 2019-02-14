package com.example.springaoptwo;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class DoAfterReturningMethod implements AfterReturningAdvice {
    public void afterReturning(Object returnValue, Method method,Object[] args, Object target) throws Throwable{
        System.out.println("*************SPRING AOP********** DoAfterReturningMethod : Excuting after method return!");
    }
}
