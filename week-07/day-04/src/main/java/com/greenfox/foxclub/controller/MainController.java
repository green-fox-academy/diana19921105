package com.greenfox.foxclub.controller;

import com.greenfox.foxclub.model.Fox;
import com.greenfox.foxclub.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private InformationService informationService;

    @Autowired
    public MainController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/")
    public String main(@RequestParam String name, Model model) {
        Fox fox = informationService.findFox(name);
        Integer tricksNumber = fox.getTricks().size();
        model.addAttribute("fox", fox);
        model.addAttribute("tricksNumber",tricksNumber);
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String sendLogin(@RequestParam String name, Model model) {
        return "redirect:/?name=" + name;
    }
}
