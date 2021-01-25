package com.greenfox.backend_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ResultSingle {
    private Integer result;

    public ResultSingle(Integer result) {
        this.result = result;
    }
}
