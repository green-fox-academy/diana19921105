package com.greenfox.backend_api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Append {
    String appended;

    public Append(String appendTo) {
        this.appended = appendTo + "a";
    }
}
