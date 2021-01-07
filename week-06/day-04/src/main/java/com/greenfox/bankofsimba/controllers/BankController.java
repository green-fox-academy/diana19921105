package com.greenfox.bankofsimba.controllers;

import com.greenfox.bankofsimba.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BankController {

    @GetMapping("/show")
    public String show(Model model) {
        BankAccount simba = new BankAccount("Simba", (double) 2000L, "lion", "Zebra");
        model.addAttribute("name", simba.getName());
        model.addAttribute("balance", simba.getBalanceFormatted());
        model.addAttribute("type", simba.getAnimalType());
        model.addAttribute("currency", simba.getCurrency());
        return "index";
    }

    @GetMapping("")
    @ResponseBody
    public String html() {
        return "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
    }
}