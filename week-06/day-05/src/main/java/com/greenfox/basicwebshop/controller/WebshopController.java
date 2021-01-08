package com.greenfox.basicwebshop.controller;

import com.greenfox.basicwebshop.model.ShopItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WebshopController {

    private List<ShopItem> items;

    public WebshopController() {
        items = new ArrayList<>();
        items.add(new ShopItem("Nike", "Running shoe", (double) 1000L, 0));
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

    @GetMapping("/only-available")
    public String onlyAvailable(Model model) {
        model.addAttribute("items", items.stream()
                .filter(i -> i.getQuantity() > 0)
                .collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/cheapest-first")
    public String cheapestFirst(Model model) {
        model.addAttribute("items", items.stream()
                .sorted(Comparator.comparing(ShopItem::getPrice))
                .collect(Collectors.toList()));
        return "index";
    }

}
