package com.greenfox.resttests.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class YonduResult {
    Double distance;
    Double time;
    Double speed;

    public YonduResult(Double distance, Double time) {
        this.distance = distance;
        this.time = time;
        this.speed = distance / time;
    }
}
