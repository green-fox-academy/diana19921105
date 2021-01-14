package com.greenfox.foxclub.controller;

import com.greenfox.foxclub.model.Drink;
import com.greenfox.foxclub.model.Food;
import com.greenfox.foxclub.model.Fox;
import com.greenfox.foxclub.service.InformationService;
import com.greenfox.foxclub.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private InformationService informationService;
    private NutritionService nutritionService;
    private Fox fox = new Fox("Green");

    @Autowired
    public MainController(InformationService informationService, NutritionService nutritionService) {
        this.informationService = informationService;
        this.nutritionService = nutritionService;
    }

    @GetMapping("/")
    public String main(@RequestParam(required = false) String name, Model model) {
        if (name == null) {
            this.fox = informationService.findFox(this.fox.getName());
        } else {
            fox = informationService.findFox(name);
        }
        Integer tricksNumber = fox.getTricks().size();
        model.addAttribute("fox", this.fox);
        model.addAttribute("tricksNumber", tricksNumber);
        model.addAttribute("tricks", fox.getTricks());
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String sendLogin(@RequestParam String name) {
        return "redirect:/?name=" + name;
    }

    @GetMapping("/information")
    public String information() {
        return "index";
    }

    @GetMapping("/nutrition-store")
    public String nutritionStore(Model model) {
        model.addAttribute("foods", nutritionService.getFoods());
        model.addAttribute("drinks", nutritionService.getDrinks());
        return "nutritionstore";
    }

    @PostMapping("nutrition-store")
    public String addFoodAndDrink(@ModelAttribute Food food,
                                  @ModelAttribute Drink drink) {

        nutritionService.addFood(food);
        nutritionService.addDrink(drink);
        return "redirect:/nutrition-store";
    }

    @PostMapping("/update-food")
    public String updateFoodAndDrink(@ModelAttribute Food food, @ModelAttribute Drink drink) {
        nutritionService.updateFoodAndDrink(food, drink, this.fox);
        return "redirect:/";
    }
}

