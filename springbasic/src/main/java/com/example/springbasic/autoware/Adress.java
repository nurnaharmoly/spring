package com.example.springbasic.autoware;

import org.springframework.stereotype.Component;

@Component
public class Adress {
    private String houseNo;
    private String country;

    public Adress() {
        System.out.println("Object Create...............");
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void show(){
        System.out.println("Show...........");
    }
}
