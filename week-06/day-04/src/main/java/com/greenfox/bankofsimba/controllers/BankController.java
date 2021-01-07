package com.greenfox.bankofsimba.controllers;

import com.greenfox.bankofsimba.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {

    @GetMapping("/show")
    public String bankAccount(Model model) {
        BankAccount simba = new BankAccount("Simba", 2000L, "lion");
        model.addAttribute("name", simba.getName());
        model.addAttribute("balance", simba.getBalance());
        model.addAttribute("type", simba.getAnimalType());
        return "index";
    }
}
