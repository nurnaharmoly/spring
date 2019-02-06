package com.example.springbasic.qualifiar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.scan("com.example.springbasic.qualifiar");
        context.refresh();;
        VehcleService service = context.getBean(VehcleService.class);
        service.service();

        context.close();
    }
}
