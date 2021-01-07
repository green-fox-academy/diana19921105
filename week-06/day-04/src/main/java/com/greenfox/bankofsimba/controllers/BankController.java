package com.greenfox.bankofsimba.controllers;

import com.greenfox.bankofsimba.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BankController {

    private List<BankAccount> bankAccountList;

    public BankController() {
        bankAccountList = new ArrayList<>();
        bankAccountList.add(new BankAccount("Nala", (double) 1500L, "lion"));
        bankAccountList.add(new BankAccount("Zazu", (double) 1L, "bird"));
        bankAccountList.add(new BankAccount("Mufasa", (double) 10000L, "lion"));
        bankAccountList.add(new BankAccount("Rafiki", (double) 2500L, "gorilla"));
        bankAccountList.add(new BankAccount("Timon", (double) 6500L, "meerkat"));
    }

    @GetMapping("/show")
    public String show(Model model) {
        BankAccount simba = new BankAccount("Simba", (double) 2000L, "lion");
        model.addAttribute("name", simba.getName());
        model.addAttribute("balance", simba.getBalanceFormatted());
        model.addAttribute("type", simba.getAnimalType());
        return "index";
    }

    @GetMapping("/ception")
    public String html(Model model) {
        String text = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
        model.addAttribute("text", text);
        return "htmlception";
    }

    @GetMapping("/accounts")
    public String getMultipleAccounts(Model model) {
        model.addAttribute("accountList", bankAccountList);
        return "multipleaccounts";
    }

}