package com.greenfox.resttests.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GrootError {
    private String error;

    public GrootError(String error) {
        this.error = "I am groot!";
    }

}
