package com.greenfox.dependency.controller;

import com.greenfox.dependency.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    public String coloredBackground(Model model) {
        model.addAttribute("color", utilityService.randomColor());
        return "colored";
    }

    @GetMapping("/useful/email")
    public String email(@RequestParam String email, Model model) {
       List<String> messageAndColor = utilityService.validateEmail(email);
        model.addAttribute("message", messageAndColor.get(0));
        model.addAttribute("color", messageAndColor.get(1));
        return "email";
    }
}
