package com.greenfox.flower;

import java.util.ArrayList;
import java.util.List;

public class GardenDemo {
    public static void main(String[] args) {
        List<Plant> plants = new ArrayList<>();
        Garden garden = new Garden(plants);

        Flower yellow = new Flower(2.0, FlowerColor.YELLOW);
        plants.add(yellow);

        Flower blue = new Flower(3.0, FlowerColor.BLUE);
        plants.add(blue);

        Tree purpleTree = new Tree(2.0, TreeColor.PURPLE);
        plants.add(purpleTree);

        Tree orangeTree = new Tree(2.0, TreeColor.ORANGE);
        plants.add(orangeTree);

        System.out.println(garden);

        garden.wateringPlants(40);

        System.out.println(garden);

        garden.wateringPlants(70);

        System.out.println(garden);
    }

}
