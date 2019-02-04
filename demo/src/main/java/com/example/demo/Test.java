package com.example.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("aplicationConfig.xml");
        BeanFactory factory = new XmlBeanFactory(resource);


        Address address = (Address) factory.getBean("addrs");
        System.out.println(address);


        Student student = (Student) factory.getBean("stu");
        System.out.println(student);

        Department department = (Department) factory.getBean("dep");
        System.out.println(department);
    }
}
