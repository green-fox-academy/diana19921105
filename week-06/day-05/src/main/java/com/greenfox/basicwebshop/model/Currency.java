package com.greenfox.basicwebshop.model;

public enum Currency {
    EUR(0.099),
    HUF(1/13.74),
    CZK(1.0);

    private Double rate;

    Currency(Double multiplicity) {
        this.rate = multiplicity;
    }

    public Double getRate() {
        return rate;
    }
}
