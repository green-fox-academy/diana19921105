package com.greenfox.resttests.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RocketResult {
    private String received;
    private Integer amount;
    private String shipStatus;
    private Boolean ready;

    public RocketResult(String received, Integer amount) {
        this.received = received;
        this.amount = amount;
        this.shipStatus = getShipStatus();
        this.ready = isReady();

    }

    public String getShipStatus() {
        int maximum = 12500;
        double percent = (double) amount / maximum * 100;
        if (percent > 0.0 && percent < 100.0) {
            return percent + "%";
        } else if (percent == 0.0) {
            return "empty";
        } else if (percent == 100.0) {
            return "full";
        } else {
            return "overloaded";
        }
    }

    public Boolean isReady() {
        return shipStatus.equals("full");
    }
}
