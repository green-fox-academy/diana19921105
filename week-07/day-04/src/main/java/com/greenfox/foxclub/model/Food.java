package com.greenfox.foxclub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class Food{

    String food;

    public String getFood() {
        return food;
    }

    public Food() {
    }

    public Food(String food) {
        this.food = food;
    }
}
