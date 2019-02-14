package com.example.springaopone;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee simpleService = (Employee) context.getBean("simpleServiceProxy");
        simpleService.printNameId();
        System.out.println("--------------");
        try {
            simpleService.checkName();
        }catch (Exception e) {
            System.out.println("Employee : Method cheakName() exception throw...");
        }
            System.out.println("----------");
            simpleService.sayHello("Wow............");
            context.close();
        }
    }

