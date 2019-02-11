package com.example.studentmvcproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
public class StudentController {

    private static String UPLOADED_FOLDER = "D:/My Git/spring/studentmvcproject/src/main/resources/static/images/ ";

    @Autowired
    private ImageOptimizer imageOptimizer;

    @Autowired
    private StudentRepo repo;

    @GetMapping("/add")
    public String showFrom(Student student){
        return "add-page";
    }

    @PostMapping("/add")
    public String save(@Valid Student student, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file){
        if(bindingResult.hasErrors()){
            return "add-page";
        }else {

            student.setRegiDate(new Date());


            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

                Files.write(path, bytes);
                student.setFileName("new-" + file.getOriginalFilename());
                student.setFileSize(file.getSize());

                student.setFilePath("images/" + "new-" + file.getOriginalFilename());
                student.setFileExtension(file.getContentType());


                this.repo.save(student);
                model.addAttribute("student", new Student());
                model.addAttribute("succMsg", "Congratulation! You are old enough to sign up for this site.");
                imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.5f, 100, 100);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
        this.repo.findAll().forEach((c) -> {
            System.out.println(c.toString());
        });
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
