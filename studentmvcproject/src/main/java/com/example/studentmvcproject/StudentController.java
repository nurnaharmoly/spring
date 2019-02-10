package com.example.studentmvcproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    private StudentRepo repo;

    @GetMapping("/add")
    public String showFrom(Student student){
        return "add-page";
    }

    @PostMapping("/add")
    public String save(@Valid Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add-page";
        }
        this.repo.save(student);
        model.addAttribute("student", new Student());
        model.addAttribute("SuccMsg", "Congratulation! You are old enough to sign up for this site.");
        return "add-page";
    }

    @GetMapping("/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id){
        model.addAttribute("student",this.repo.getOne(id));
        return "edit-page";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid Student student, BindingResult bindingResult, Model model, @PathVariable("id") Long id){
        if(bindingResult.hasErrors()){
            return "edit-page";
        }
        this.repo.save(student);
        model.addAttribute("student", new Student());
        return "redirect:/";
        }

        @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "index";
        }

        @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Long id){
        if(id != null){
            this.repo.deleteById(id);
        }
        return "redirect:/";
        }

}
