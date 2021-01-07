package com.greenfox.bankofsimba.controllers;

import com.greenfox.bankofsimba.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {

    @GetMapping("/show")
    public String show(Model model) {
        BankAccount simba = new BankAccount("Simba", (double) 2000L, "lion");
        model.addAttribute("name", simba.getName());
        model.addAttribute("balance", simba.getBalanceFormatted());
        model.addAttribute("type", simba.getAnimalType());
        return "index";
    }

    @GetMapping("ception")
    public String html(Model model) {
        String text = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
        model.addAttribute("text", text);
        return "htmlception";
    }
}