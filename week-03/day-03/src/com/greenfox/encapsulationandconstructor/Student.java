package com.greenfox.encapsulationandconstructor;

public class Student {

    public void learn() {
        System.out.println("Learning something new...");
    }

    public void question(Teacher teacher) {
        teacher.answer();
    }
}
