package com.greenfox.bankofsimba.model;

import java.util.Objects;

public class BankAccount {
    private String name;
    private Double balance;
    private String animalType;
    private String currency;
    private boolean isKing;
    private boolean isBadGuy;

    public BankAccount(String name, Double balance, String animalType, Boolean isKing, Boolean isBadGuy) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.currency = "Zebra";
        this.isKing = isKing;
        this.isBadGuy = isBadGuy;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isKing() {
        return isKing;
    }

    public boolean isBadGuy() {
        return isBadGuy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return isKing() == that.isKing() &&
                isBadGuy() == that.isBadGuy() &&
                getName().equals(that.getName()) &&
                getBalance().equals(that.getBalance()) &&
                getAnimalType().equals(that.getAnimalType()) &&
                getCurrency().equals(that.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBalance(), getAnimalType());
    }

    public String getBalanceFormatted() {
        return String.format("%.2f", balance) + " " + getCurrency();
    }

    public String getStyle() {
        if (isKing) {
            return "king";
        } else {
            return "basic";
        }
    }

    public String badOrGood() {
        if (isBadGuy) {
            return "bad guy";
        } else {
            return "good one";
        }
    }

    public void raiseTheBalance() {
        if (isKing()) {
            balance += 100;
        } else {
            balance += 10;
        }
    }
}
