package com.example.webmvcthymeleaf.controller;

import com.example.webmvcthymeleaf.entity.Save;
import com.example.webmvcthymeleaf.entity.User;
import com.example.webmvcthymeleaf.repository.SaveRepo;
import com.example.webmvcthymeleaf.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SaveController {
    @Autowired
    private SaveRepo repo;

    @GetMapping(value = "/add")
    public String showFrom(Save save){
       return "saveview";

    }
@PostMapping(value = "/add")
    public String save(@Valid Save save, BindingResult bindingResult, Model model) {
    ModelAndView mv = new ModelAndView();

    if (bindingResult.hasErrors()) {
        return "saveview";
    }
    this.repo.save(save);
    model.addAttribute("save", new Save());
    model.addAttribute("successMge", "Congratulation! You are old enough to sing up for this site.");
    return "saveview";
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



    @GetMapping(value = "/edit/{id}")
    public String editView( Model model, @PathVariable("id") Long id{
        model.addAttribute("user",this.repo. ) )
    }
        return "saveview";

    @PostMapping(value = "/edit/{id}")
    public String edit(@Valid Save save, BindingResult bindingResult, Model model) {
        ModelAndView mv = new ModelAndView();

        if (bindingResult.hasErrors()) {
            return "editview";
        }
        this.repo.save(save);
        model.addAttribute("save", new Save());


        return "redirect:/";

    }
}
