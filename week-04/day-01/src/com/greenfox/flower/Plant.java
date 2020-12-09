package com.greenfox.flower;

public abstract class Plant {
    protected double waterAmount;

    public double getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(double waterAmount) {
        this.waterAmount = waterAmount;
    }

    public abstract boolean needsWater();

    public abstract void watering(double water);
}
