package com.greenfox.backend_api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class Arrays {
    private List<Integer> numbers;
    private String what;

    public Arrays(List<Integer> numbers, String what) {
        this.numbers = numbers;
        this.what = what;
    }

    @Override
    public String toString() {
        return "numbers: " + numbers + " , what: " + what;
    }
}
