package com.greenfox.printable;

public class Domino implements Printable {
    int ASide;
    int BSide;

    public Domino(int ASide, int BSide) {
        this.ASide = ASide;
        this.BSide = BSide;
    }

    public Domino() {
        ASide = 3;
        BSide = 2;
    }

    @Override
    public void printAllFields() {
        System.out.println("Domino A side: " + ASide + ", B side: " + BSide);
    }
}
