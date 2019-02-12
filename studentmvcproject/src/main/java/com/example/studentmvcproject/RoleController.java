package com.example.studentmvcproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RoleController {
    @Autowired
    private RoleRepo roleRepo;


    @GetMapping(value = "/add-role")
    public String addRoleView(Role role) {
        return "role/add";
    }

    @PostMapping(value = "/add-role")
    public String addRole(@Valid Role role, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "role/add";
        } else {
            if (role != null) {
                Role role1 = this.roleRepo.findByRoleName(role.getRoleName());
                if (role1 != null) {
                    model.addAttribute("exisMsg", "Role Name is already Exist");
                } else {
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("successMsg", "Successfully Data");
                }
            }
        }
        return "role/add";
       }
@GetMapping(value = "/role-list")
       public String roleList(Model model){
        model.addAttribute("list", this.roleRepo.findAll());
        return "role/list";
       }
    }