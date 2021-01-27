package com.greenfox.backend_api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Result {
    private Integer result;
    private String action;
    private Integer until;

    public Result(String action, Integer until) {
        if (action.equals("sum")) {
            int sum = 0;
            for (int i = 0; i < until + 1; i++) {
                sum += i;
            }
            result = sum;
        }

        if (action.equals("factor")) {
            int factor = 1;
            for (int i = 1; i < until + 1; i++) {
                factor *= i;
            }
            result = factor;
        }
    }
}
