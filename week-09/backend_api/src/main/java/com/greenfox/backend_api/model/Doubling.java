package com.greenfox.backend_api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Doubling {
    private Integer received;
    private Integer result;

    public Doubling(Integer input) {
        received = input;
        result = input * 2;
    }

}
