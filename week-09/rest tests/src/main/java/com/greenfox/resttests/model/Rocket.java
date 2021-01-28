package com.greenfox.resttests.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Rocket {
    Integer caliber25 = 0;
    Integer caliber30 = 0;
    Integer caliber50 = 0;
    String shipStatus = "empty";
    Boolean ready = false;

}
