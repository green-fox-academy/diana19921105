package com.greenfox.flower;

import java.util.List;

public class Garden {
    protected List<Plant> plants;

    public Garden(List<Plant> plants) {
        this.plants = plants;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Plant plant : plants) {
            stringBuilder.append(plant).append("\n");
        }
        return stringBuilder.toString();
    }

    public void wateringPlants(double water) {
        int numberOfPlantNeedsWater = 0;

        for (Plant plant : plants) {
            if (plant.needsWater()) {
                numberOfPlantNeedsWater++;
            }
        }
        double wateringAmount = water / numberOfPlantNeedsWater;

        for (Plant plant : plants) {
            if (plant.needsWater()) {
                plant.watering(wateringAmount);
            }
        }


    }
}
