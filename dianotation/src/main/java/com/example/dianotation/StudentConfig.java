package com.example.dianotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean(name = "student")
    public Student getsStudent(){

        Student student = new Student(100, "Moly R L");
        return student;

    }


    @Bean(name = "student2")
    public Student getStudentSetter(){
        Student student = new Student();
        student.setId(500);
        student.setName("Mr Ben");
        return student;
    }
}
