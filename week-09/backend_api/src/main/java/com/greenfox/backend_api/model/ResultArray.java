package com.greenfox.backend_api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class ResultArray {
    private List<Integer> result;

    public ResultArray(List<Integer> result) {
        this.result = result.stream()
                .map(i -> i * 2)
                .collect(Collectors.toList());
    }
}
