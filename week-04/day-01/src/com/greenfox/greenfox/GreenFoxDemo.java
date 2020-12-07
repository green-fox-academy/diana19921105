package com.greenfox.greenfox;

import java.util.ArrayList;

public class GreenFoxDemo {
    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();

        Person mark = new Person("Mark", 46, Gender.MALE);
        mark.introduce();
        mark.getGoal();
        people.add(mark);

        Person jane = new Person();
        jane.introduce();
        jane.getGoal();
        people.add(jane);

        Student john = new Student("John Doe", Gender.MALE, 20, "BME", 0);
        john.introduce();
        john.getGoal();
        people.add(john);

        Student student = new Student();
        student.introduce();
        student.getGoal();
        people.add(student);

        Mentor gandhi = new Mentor("Gandhi", 148, Gender.FEMALE, Level.SENIOR);
        gandhi.introduce();
        gandhi.getGoal();
        people.add(gandhi);

        Mentor mentor = new Mentor();
        mentor.introduce();
        mentor.getGoal();
        people.add(mentor);

        Sponsor sponsor = new Sponsor();
        sponsor.introduce();
        sponsor.getGoal();
        people.add(sponsor);

        Sponsor elon = new Sponsor("Elon Musk", 46, Gender.MALE, "SpaceX");
        elon.introduce();
        elon.getGoal();
        people.add(elon);

        student.skippedDays(3);

        for (int i = 0; i < 5; i++) {
            elon.hire();
        }

        for (int i = 0; i < 3; i++) {
            sponsor.hire();
        }

        for (Person person : people) {
            person.introduce();
            person.getGoal();
        }

        Cohort awesome = new Cohort("AWESOME");
        awesome.addStudent(student);
        awesome.addStudent(john);
        awesome.addMentor(mentor);
        awesome.addMentor(gandhi);
        awesome.info();
    }

}
