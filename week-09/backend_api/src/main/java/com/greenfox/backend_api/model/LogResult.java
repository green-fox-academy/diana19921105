package com.greenfox.backend_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogResult {

    @JsonProperty("entry_count")
    Integer entryCount;
    List<LogResponseDto> entries = new ArrayList<>();
}
