package com.example.beanlifcyclethree;

public class Employee {

    private int id;

    private String position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
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

    public void inti(){
        System.out.println("i am initialisation");

    }

    public void cleanUp(){
        System.out.println("I am clean cleanup");

    }
}
