package com.greenfox.resttests.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GrootResult {
    private String received;
    private String translated = "I am Groot!";

    public GrootResult(String received) {
        this.received = received;
    }
}
