package com.greenfox.basicwebshop.model;

import java.util.Objects;

public class ShopItem {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private Currency currency;
    private Type type;

    public ShopItem(String name, String description, Double price, Integer quantity, Currency currency, Type type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.currency = currency;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopItem shopItem = (ShopItem) o;
        return getName().equals(shopItem.getName()) &&
                getDescription().equals(shopItem.getDescription()) &&
                getPrice().equals(shopItem.getPrice()) &&
                Objects.equals(getQuantity(), shopItem.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getPrice(), getQuantity());
    }

    public String getPriceFormatted() {
        return String.format("%.2f", price) + " " + getCurrency();
    }
}
