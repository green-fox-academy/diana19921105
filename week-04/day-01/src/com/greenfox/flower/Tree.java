package com.greenfox.flower;

public class Tree extends Plant {
    protected TreeColor color;

    public Tree(double waterAmount, TreeColor color) {
        this.waterAmount = waterAmount;
        this.color = color;
    }

    public TreeColor getColor() {
        return color;
    }

    public void setColor(TreeColor color) {
        this.color = color;
    }

    @Override
    public boolean needsWater() {
        return this.waterAmount < 10.0;
    }

    @Override
    public void watering(double water) {
        this.waterAmount += water * 0.4;
    }

    @Override
    public String toString() {
        return "The " + color + " tree " + (needsWater() ? "needs water" : "doesn't need water");
    }
}
