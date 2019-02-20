package com.example.loginmysql.controller;

import com.example.loginmysql.entity.Role;
import com.example.loginmysql.entity.User;

import com.example.loginmysql.repo.RoleRepo;
import com.example.loginmysql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/user")
public class UserController {





    @Autowired
    private UserRepo repo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
     private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("list", this.repo.findAll());
        this.repo.findAll().forEach((c) -> {
            System.out.println(c.toString());
        });
        return "usercurd/index";
    }

    @GetMapping("/add")
    public String showForm(User user, Model model) {
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "usercurd/add-page";
    }

    @PostMapping("/add")
    public String save(@Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "usercurd/add-page";
        }else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.repo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("roleList", this.roleRepo.findAll());
            model.addAttribute("successMsg", "Congratulations! You are old enough to sign up for this site.");
            }
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "usercurd/add-page";
    }


    @GetMapping("/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id) {

        model.addAttribute("user", this.repo.getOne(id));
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "usercurd/edit-page";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid User user, BindingResult bindingResult,Model model,
                       @PathVariable("id") Long id) {

        if (bindingResult.hasErrors()) {
            return "usercurd/edit-page";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.repo.save(user);
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "redirect:/user/index";
    }


    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/user/index";
    }



//        @Autowired
//    private UserRepo repo;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    @GetMapping(value = "/user-save")
//    public void saveUser(){
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(1L));
//        roles.add(new Role(2L));
//        User user = new User("Joni", "Joni",passwordEncoder.encode("1234"), "joni@gmail.com", true, roles );
//        repo.save(user);
//
//        Set<Role> roles2 = new HashSet<>();
//        roles2.add(new Role(3L));
//        User user2 = new User("Fami", "Fami",passwordEncoder.encode("1234"), "fami@gmail.com", true, roles2 );
//        repo.save(user2);
//
//        Set<Role> roles3 = new HashSet<>();
//        roles3.add(new Role(2L));
//        User user3 = new User("Piya", "Piya",passwordEncoder.encode("1234"), "piya@gmail.com", true, roles3 );
//        repo.save(user3);
//    }
//


}
