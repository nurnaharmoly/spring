package com.example.springbasic.qualifiar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VehcleService {

    @Autowired
    @Qualifier(value = "hondaBean")
    private Vechicle vechicle;

    public void service(){
        vechicle.start();
        vechicle.stop();
    }

}
