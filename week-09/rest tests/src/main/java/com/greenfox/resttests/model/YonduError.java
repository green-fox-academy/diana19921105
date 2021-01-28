package com.greenfox.resttests.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class YonduError {
    private String error;

    public YonduError(String error) {
        this.error = "Something went wrong!";
    }
}
