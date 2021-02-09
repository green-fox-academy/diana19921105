package com.greenfox.resttests.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    private Long id;
    private Integer amount;
    private String name;
    private Integer calorie;
}
