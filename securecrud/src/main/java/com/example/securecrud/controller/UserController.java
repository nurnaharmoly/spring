package com.example.securecrud.controller;


import com.example.securecrud.entity.Role;
import com.example.securecrud.entity.User;
import com.example.securecrud.repo.UserRepo;
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


//    @GetMapping(value = "/user-save")
//    public String saveUser(){
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(1L));
//        roles.add(new Role(3L));
//        User user = new User("moly", "moly", passwordEncoder.encode("1234"), "moly@gmail.com", true, roles);
//        repo.save(user);
//
//        Set<Role> roles1 = new HashSet<>();
//        roles1.add(new Role(3L));
//        User user1 = new User("tina", "tina", passwordEncoder.encode("1234"), "tina@gmail.com", true, roles1);
//        repo.save(user1);
//
//        Set<Role> roles2 = new HashSet<>();
//        roles2.add(new Role(2L));
//        User user2 = new User("koli", "koli", passwordEncoder.encode("1234"), "koli@gmail.com", true, roles2);
//        repo.save(user2);
//
//        return "success";
//    }

}
