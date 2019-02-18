package com.example.loginmysql.controller;

import com.example.loginmysql.entity.Role;
import com.example.loginmysql.entity.User;

import com.example.loginmysql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping(value = "/user-save")
    public void saveUser(){
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1L));
        roles.add(new Role(2L));
        User user = new User("tuly", "sadmin",passwordEncoder.encode("1234"), "arif@gmail.com", true, roles );
        repo.save(user);

        Set<Role> roles2 = new HashSet<>();
        roles.add(new Role(2L));
        User user2 = new User("Runa", "admin",passwordEncoder.encode("1234"), "runa@gmail.com", true, roles2 );
        repo.save(user2);

        Set<Role> roles3 = new HashSet<>();
        roles3.add(new Role(3L));
        User user3 = new User("Piya", "user",passwordEncoder.encode("1234"), "piya@gmail.com", true, roles3 );
        repo.save(user3);
    }
}
