package com.example.loginmysql.controller;

import com.example.loginmysql.entity.User;
import com.example.loginmysql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class Test {


        @Autowired
    private UserRepo repo;


        @ResponseBody
        @GetMapping(value = "/test")
        private Optional<User> display(){
            return repo.findByUserNameOrEmail("Joni","");
        }





}
