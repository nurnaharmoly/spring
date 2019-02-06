package com.example.hellomvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping(value =  "/")
    public String home(){
        return "Hello mvc";

    }

    @GetMapping(value =  "/test")
    public String test(){
        return "Hello test";

    }
}
