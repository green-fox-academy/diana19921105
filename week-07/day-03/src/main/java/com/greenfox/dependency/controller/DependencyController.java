package com.greenfox.dependency.controller;

import com.greenfox.dependency.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DependencyController {

    private UtilityService utilityService;

    @Autowired
    public DependencyController(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    @GetMapping("/useful")
    public String main() {
        return "useful";
    }

    @GetMapping("/useful/colored")
    public String coloredBackground() {
        return "colored";
    }

    @GetMapping("/useful/email")
    public String email(@RequestParam String email, Model model) {
        model.addAttribute("email", email);
        return "useful";
    }
}
