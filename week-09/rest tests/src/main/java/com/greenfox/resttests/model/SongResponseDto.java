package com.greenfox.resttests.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongResponseDto {
    private String title;
    private String author;
    private Integer rating;
    private Integer year;

}
