package com.greenfox.greenfox;

public class Mentor extends Person {
    Level level;

    public Mentor(String name, int age, Gender gender, Level level) {
        super(name, age, gender);
        this.level = level;
    }

    public Mentor() {
        level = Level.INTERMEDIATE;
    }

    @Override
    protected void getGoal() {
        System.out.println("Educate brilliant junior software developers.");
    }

    @Override
    protected void introduce() {
        super.introduce();
        System.out.println(level + " mentor");

    }

}
