package com.example.crudtest;

import com.sun.java.swing.plaf.motif.resources.motif_de;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepo repo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping (value = "/")
    public String index(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "index";

    }

    @GetMapping("/add")
    public String showForm(User user){
        return "add-page";
    }

    @PostMapping("/add")
    public String save(@Valid User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add-page";
        }else {
            this.repo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("role",this.roleRepo.findAll());
            model.addAttribute("succMsg", "Congratulations");
        }
        model.addAttribute("roleList",this.roleRepo.findAll());
        return "add-page";
    }

}
