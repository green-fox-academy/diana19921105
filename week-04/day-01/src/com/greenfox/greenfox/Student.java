package com.greenfox.greenfox;

public class Student extends Person {
    protected String previousOrganization;
    protected int skippedDays;


    public Student(String name, Gender gender, int age, String previousOrganization, int skippedDays) {
        super(name, age, gender);
        this.previousOrganization = previousOrganization;
        this.skippedDays = skippedDays;
    }

    public Student() {
        skippedDays = 0;
        previousOrganization = "The School of Life";
    }

    @Override
    public void getGoal() {
        System.out.println("Be a junior software developer.");
    }

    @Override
    protected void introduce() {
        super.introduce();
        System.out.println(" from " + previousOrganization + " who skipped " + skippedDays + " days from the curse already.");
    }

    protected int skippedDays(int numberOfDays) {
        skippedDays += numberOfDays;
        return skippedDays;
    }
}
