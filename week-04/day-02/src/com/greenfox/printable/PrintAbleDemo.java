package com.greenfox.printable;

import java.util.ArrayList;
import java.util.List;

public class PrintAbleDemo {
    public static void main(String[] args) {
        List<Domino> dominoList = new ArrayList<>();
        List<Todo> todos = new ArrayList<>();

        Domino domino = new Domino();
        Domino domino1 = new Domino(5,8);
        Todo todo = new Todo();
        Todo todo2 = new Todo("Clean the room", "high", false);

        dominoList.add(domino);
        dominoList.add(domino1);
        todos.add(todo);
        todos.add(todo2);

        for(Domino d : dominoList) {
            d.printAllFields();
        }

        for(Todo td : todos) {
            td.printAllFields();
        }


    }
}
