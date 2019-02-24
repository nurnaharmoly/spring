package com.example.securecrud.controller;

import com.example.securecrud.entity.Role;
import com.example.securecrud.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {

    @Autowired
    private RoleRepo repo;

    @GetMapping(value = "/role-save")
    public String saveRole(){
        Role role = new Role();
        role.setRoleName("SUPERADMIN");
        repo.save(role);

        Role role1 = new Role();
        role1.setRoleName("ADMIN");
        repo.save(role1);

        Role role2 = new Role();
        role2.setRoleName("USER");
        repo.save(role2);

        return "success";
    }
}
