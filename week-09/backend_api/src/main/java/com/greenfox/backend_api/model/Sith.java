package com.greenfox.backend_api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class Sith {
    private String text;

    public Sith(String text) {
        String resultString = text;
        String[] split = resultString.split("\\. ");

        for (String s : split) {
            String[] splitBySpace = s.split(" ");
            List<String> strings = Arrays.asList(splitBySpace);

            if (strings.size() % 2 == 0) {
                for (int j = 0; j < strings.size(); j += 2) {

                    String temp = strings.get(j);
                    strings.set(j, strings.get(j + 1));
                    strings.set(j + 1, temp);

                    resultString = strings.toString();
                }
            }
        }
        this.setText(resultString);
    }
}
