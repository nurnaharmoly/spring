package com.example.loginmysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/adm")
    public String adminViwe(){
        return "admin/admin";
    }

    @GetMapping(value = "/sa")
    public String superAdminviwe(){
        return "sadmin/sad";
    }

    @GetMapping(value = "/se")
    public String secureViwe(){
        return "secure/sec";
    }

    @GetMapping(value = "/u")
    public String userViwe(){
        return "user/u";
    }




}
