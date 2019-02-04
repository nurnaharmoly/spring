package com.example.demohw;

public class Department {
    private int depId;
    private String name;


    public Department(int depId, String name) {
        this.depId = depId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", name='" + name + '\'' +
                '}';
    }
}
