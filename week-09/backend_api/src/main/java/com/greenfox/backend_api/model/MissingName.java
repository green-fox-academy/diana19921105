package com.greenfox.backend_api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MissingName {

    private String error = "Please provide a name!";
}

