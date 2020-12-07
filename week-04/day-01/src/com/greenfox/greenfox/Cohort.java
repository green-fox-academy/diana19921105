package com.greenfox.greenfox;

import java.util.ArrayList;
import java.util.List;

public class Cohort {
    protected String name;
    protected List<Student> students;
    protected List<Mentor> mentors;

    public Cohort(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.mentors = new ArrayList<>();
    }

    public List<Student> addStudent(Student student) {
        students.add(student);
        return students;
    }

    public List<Mentor> addMentor(Mentor mentor) {
        mentors.add(mentor);
        return mentors;
    }

    public void info() {
        System.out.println("The " + name + " cohort has " + students.size() + " students and " + mentors.size() + " mentors");
    }
}
