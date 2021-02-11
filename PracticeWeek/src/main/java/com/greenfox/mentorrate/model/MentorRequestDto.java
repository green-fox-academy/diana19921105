package com.greenfox.mentorrate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MentorRequestDto {
    private String name;
    private String className;
}
