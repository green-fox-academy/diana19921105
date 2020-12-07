package com.greenfox.greenfox;

public class Sponsor extends Person {
    protected String company;
    protected int hiredStudents;

    public Sponsor(String name, int age, Gender gender, String company) {
        super(name, age, gender);
        this.company = company;
    }

    public Sponsor() {
        company = "Google";
        hiredStudents = 0;
    }

    @Override
    protected void introduce() {
        super.introduce();
        System.out.println("who represents" + company + "and hired" + hiredStudents + "students so far");
    }

    public int hire() {
        hiredStudents++;
        return hiredStudents;
    }

    @Override
    protected void getGoal() {
        System.out.print("Hire brilliant junior software developers.");
    }
}
