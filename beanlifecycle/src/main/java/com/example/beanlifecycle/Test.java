package com.example.beanlifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanConfig.xml");
        SempleBean sempleBean = (SempleBean) context.getBean("sb1");
        System.out.println(sempleBean);

        SempleBean sempleBean2 = (SempleBean) context.getBean("sb2");
        System.out.println(sempleBean2);
    }
}
