package com.example.beanlifecyclefour;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Employee employee = (Employee) context.getBean("emp");
        System.out.println(employee);
        context.close();
    }
}
