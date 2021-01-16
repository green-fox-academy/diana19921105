package com.greenfox.foxclub.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Fox {
    private String name;
    private List<Trick> tricks = new ArrayList<>();
    private Food food = new Food("bread");
    private Drink drink = new Drink("water");

    public Fox(String name, List<Trick> tricks, Food food, Drink drink) {
        this.name = name;
        this.tricks = tricks;
        this.food = food;
        this.drink = drink;
    }

    public Fox() {
    }

    public Fox(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Trick> getTricks() {
        return tricks;
    }

    public void setTricks(List<Trick> tricks) {
        this.tricks = tricks;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public List<Trick> addTrick(Trick trick) {
        tricks.add(trick);
        return tricks;
    }
}
