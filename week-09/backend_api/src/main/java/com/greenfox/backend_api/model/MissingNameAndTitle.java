package com.greenfox.backend_api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MissingNameAndTitle {

    private String error = "Please provide a name and a title!";
}
