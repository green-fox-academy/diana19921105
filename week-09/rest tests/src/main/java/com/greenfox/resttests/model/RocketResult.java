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
        this.shipStatus = shipStatus();
        this.ready = isReady();
    }

    public String shipStatus() {
        if (amount / Double.parseDouble(received) == 40.0) {
            this.shipStatus = "40%";
        } else if (amount / Double.parseDouble(received) == 0.0) {
            this.shipStatus = "empty";
        } else if (amount / Double.parseDouble(received) == 100.0) {
            this.shipStatus = "full";
        } else if (amount / Double.parseDouble(received) > 100.0) {
            this.shipStatus = "overloaded";
        }
        return shipStatus;
    }


    public Boolean isReady() {
        return shipStatus.equals("full");
    }
}
