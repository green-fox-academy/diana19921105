package com.greenfox.flower;

public class Flower extends Plant {
    protected FlowerColor color;

    public Flower(double waterAmount, FlowerColor color) {
        this.waterAmount = waterAmount;
        this.color = color;
    }

    public FlowerColor getColor() {
        return color;
    }

    public void setColor(FlowerColor color) {
        this.color = color;
    }

    @Override
    public boolean needsWater() {
        return this.waterAmount < 5.0;
    }

    @Override
    public void watering(double water) {
        this.waterAmount += water * 0.75;

    }

    @Override
    public String toString() {
        return "The " + color + " flower " + (needsWater() ? "needs water" : "doesn't need water");
    }
}
