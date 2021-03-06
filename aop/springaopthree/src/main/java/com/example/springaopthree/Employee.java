package com.example.springaopthree;

public class Employee {
    private String name;

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printNameId() {
        System.out.println("SimpleService : Method PrintNameId() : My name is " + name + "and my id is" + id);
    }

    public void checkName() {
        if (name.length() < 20) {
            throw new IllegalArgumentException();
        }
    }

    public void sayHello(String message) {
        System.out.println("SimpleService : Method sayHello() : Hello! " + message);
    }
}
