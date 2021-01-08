package com.greenfox.basicwebshop.controller;

import com.greenfox.basicwebshop.model.ShopItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Controller
public class WebshopController {

    private List<ShopItem> items;

    public WebshopController() {
        items = new ArrayList<>();
        items.add(new ShopItem("Nike", "Running shoe", (double) 1000L, 0));
        items.add(new ShopItem("Running shoes", "Nike shoe in different colors", (double) 1000L, 10));
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

    @GetMapping("/contains-nike")
    public String containsNike(Model model) {
        model.addAttribute("items", items.stream()
                .filter(item -> item.getName().toLowerCase().contains("nike") || item.getDescription().toLowerCase().contains("nike"))
                .collect(Collectors.toList()));

        return "index";
    }

    @GetMapping("/average-stock")
    public String averageStock(Model model) {
        OptionalDouble optionalDouble = getAverage();
        String average = "Average Stock: ";
        if (optionalDouble.isPresent()) {
            model.addAttribute("average", average + String.format("%.1f", optionalDouble.getAsDouble()));
        }
        return "average";
    }

    @GetMapping("/most-expensive")
    public String getMostExpensive(Model model) {
        Optional<String> mostExpensiveName = getMostExpensive();
        String string = "The most expensive item is: ";
        if (mostExpensiveName.isPresent()) {
            model.addAttribute("mostExpensiveName", string + mostExpensiveName.get());
        }
        return "average";
    }

    @PostMapping("/search")
    public String search(@RequestParam String search, Model model) {
        List<ShopItem> collect = searchItem(search);
        model.addAttribute("items", collect);

        return "index";
    }

    private OptionalDouble getAverage() {
        return items.stream()
                .mapToDouble(ShopItem::getQuantity)
                .average();
    }

    private Optional<String> getMostExpensive() {
        Optional<String> name = items.stream().
                max(Comparator.comparing(ShopItem::getPrice))
                .map(ShopItem::getName);

        return name;
    }

    private List<ShopItem> searchItem(String str) {
        List<ShopItem> collect = items.stream()
                .filter(i -> i.getName().toLowerCase().equals(str) || i.getDescription().toLowerCase().equals(str))
                .collect(Collectors.toList());

        return collect;
    }

}
