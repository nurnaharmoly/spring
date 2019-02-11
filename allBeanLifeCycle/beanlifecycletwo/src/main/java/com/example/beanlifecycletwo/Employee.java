package com.example.beanlifecycletwo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean {

    private int id;

    private String position;


    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("I am destroy.....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("I am Proparty.....");
    }
}
