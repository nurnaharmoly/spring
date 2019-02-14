package com.example.springaopthree;

import org.springframework.aop.ThrowsAdvice;

public class DoAfterThrowingExceptionMethod implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException e) throws Throwable{
        System.out.println("******SPRING AOP********DOAfterThrowinExceptionMethod : Executing when method throws expception");
    }
}
