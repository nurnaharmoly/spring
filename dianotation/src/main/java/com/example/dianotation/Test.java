package com.example.dianotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);

        Student student= (Student) context.getBean("student");
        System.out.println(student);

        Student studen2= (Student) context.getBean("student2");
        System.out.println(studen2);

    }
}
