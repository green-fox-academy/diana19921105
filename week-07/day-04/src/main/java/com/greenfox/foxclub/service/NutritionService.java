package com.greenfox.foxclub.service;

import com.greenfox.foxclub.model.Drink;
import com.greenfox.foxclub.model.Food;
import com.greenfox.foxclub.model.Fox;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NutritionService {
    private List<Food> foods;
    private List<Drink> drinks;

    public NutritionService() {
        foods = new ArrayList<>();
        drinks = new ArrayList<>();

        foods.add(new Food("bread"));
        foods.add(new Food("pizza"));
        foods.add(new Food("salad"));
        foods.add(new Food("chicken"));

        drinks.add(new Drink("wine"));
        drinks.add(new Drink("lemonade"));
        drinks.add(new Drink("juice"));
        drinks.add(new Drink("cola"));
    }

    public List<Food> getFoods() {
        return foods;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void updateFoodAndDrink(Food food, Drink drink, Fox fox) {
        fox.setFood(food);
        fox.setDrink(drink);
    }
}
