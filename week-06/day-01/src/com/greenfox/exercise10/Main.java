package com.greenfox.exercise10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Fox> foxes = new ArrayList<>();

        foxes.add(new Fox("Vuk", "green", 2));
        foxes.add(new Fox("Karak", "red", 18));
        foxes.add(new Fox("Sanyi", "brown", 5));
        foxes.add(new Fox("Feri", "yellow", 8));
        foxes.add(new Fox("Misi", "green", 6));
        foxes.add(new Fox("Foxy", "green", 1));
        foxes.add(new Fox("Maxy", "brown", 25));

        List<String> greenFoxes = foxes.stream()
                .filter(fox -> fox.getColor().equals("green"))
                .map(Fox::getName)
                .collect(Collectors.toList());
        System.out.println(greenFoxes);

        List<String> youngGreenFoxes = foxes.stream()
                .filter(fox -> fox.getColor().equals("green"))
                .filter(fox -> fox.getAge() < 5)
                .map(Fox::getName)
                .collect(Collectors.toList());
        System.out.println(youngGreenFoxes);

        Map<String, Long> frequencyByColor = foxes.stream()
                .collect(Collectors.groupingBy(Fox::getColor, Collectors.counting()));
        System.out.println(frequencyByColor);
    }
}
