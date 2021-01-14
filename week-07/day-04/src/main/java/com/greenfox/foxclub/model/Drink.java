package com.greenfox.foxclub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


public class Drink{
    String drink;

    public Drink() {
    }

    public Drink(String drink) {
        this.drink = drink;
    }

    public String getDrink() {
        return drink;
    }
}
