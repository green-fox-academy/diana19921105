package com.greenfox.greenfox;

public class Person {
    protected String name;
    protected int age;
    protected Gender gender;


    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public Person() {
        name = "Jane Doe";
        age = 30;
        gender = Gender.FEMALE;
    }

    protected void introduce() {
        System.out.println("Hi, I'm " + name + " a " + age + " year old " + gender);

    }

    protected void getGoal() {
        System.out.println("My goal is live for the moment.");
    }

    }
