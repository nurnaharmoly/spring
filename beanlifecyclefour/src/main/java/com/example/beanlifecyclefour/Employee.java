package com.example.beanlifecyclefour;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee {
    private int id;

    private String posision;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosision() {
        return posision;
    }

    public void setPosision(String posision) {
        this.posision = posision;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", posision='" + posision + '\'' +
                '}';
    }

    @PostConstruct
    public void initIt(){
        System.out.println("Spring inti");

    }
    @PreDestroy
    public void cleanUp(){
        System.out.println("Spring destory");
    }


}
