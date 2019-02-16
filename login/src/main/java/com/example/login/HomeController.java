package com.example.login;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

   @GetMapping(value = {"/", "/login"})
   public String loginView() {
       return "login";
   }

    @GetMapping("/public/r")
    public String home() {
        return "public/regi";
    }

    @GetMapping("/user/u")
    public String regi() {
        return "user/user";
    }

    @GetMapping("/admin/h")
    public String user() {
        return "admin/home";
    }
}
