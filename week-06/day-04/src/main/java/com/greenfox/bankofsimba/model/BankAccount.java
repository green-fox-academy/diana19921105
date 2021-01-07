package com.greenfox.bankofsimba.model;

import java.util.Objects;

public class BankAccount {
    private String name;
    private Double balance;
    private String animalType;
    private String currency;

    public BankAccount(String name, Double balance, String animalType) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.currency = "Zebra";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return getName().equals(that.getName()) &&
                Objects.equals(getBalance(), that.getBalance()) &&
                getAnimalType().equals(that.getAnimalType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBalance(), getAnimalType());
    }

    public String getBalanceFormatted() {
        return String.format("%.2f", balance) + " " + getCurrency();
    }
}
