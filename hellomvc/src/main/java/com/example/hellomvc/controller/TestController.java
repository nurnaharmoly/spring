package com.example.hellomvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/tt")
    public String test(@RequestParam(value = "ms", required = true, defaultValue = "Hello World") String msg){

        return msg;
    }
}
