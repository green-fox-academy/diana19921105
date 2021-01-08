package com.greenfox.basicwebshop.controller;

import com.greenfox.basicwebshop.model.ShopItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebshopController {

    private List<ShopItem> items;

    public WebshopController() {
        items = new ArrayList<>();
        items.add(new ShopItem("Nike", "Running shoe", (double) 1000L, 32));
        items.add(new ShopItem("Printer", "Some HP printer that makes its job", (double) 3000L, 10));
        items.add(new ShopItem("Coca cola", "Delicious cola", (double) 10L, 100));
        items.add(new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", (double) 119L, 1));
        items.add(new ShopItem("T-shirt", "Blue with a corgi", (double) 300L, 1));
    }

    @GetMapping("/webshop")
    public String landingPage(Model model) {
        model.addAttribute("items", items);
        return "index";
    }
}
