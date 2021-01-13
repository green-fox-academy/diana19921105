package com.greenfox.dependency.controller;

import com.greenfox.dependency.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreenFoxController {

    private StudentService studentService;

    @Autowired
    public GreenFoxController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/gfa")
    public String main(Model model) {
        model.addAttribute("nameList", studentService.findAll());
        return "main";
    }

    @GetMapping("/gfa/list")
    public String listStudents(Model model) {
        model.addAttribute("nameList", studentService.findAll());
        return "listStudents";
    }

    @PostMapping("/gfa/add")
    public String add(@RequestParam String name) {
        studentService.save(name);
        return "redirect:/gfa/list";
    }

    @GetMapping("/gfa/add")
    public String addStudent() {
        return "addStudent";
    }
}
