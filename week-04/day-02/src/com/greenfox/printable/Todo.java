package com.greenfox.printable;

public class Todo implements Printable {
    String task;
    String priority;
    boolean isTheTaskDone;

    public Todo(String task, String priority, boolean isTheTaskDone) {
        this.task = task;
        this.priority = priority;
        this.isTheTaskDone = isTheTaskDone;
    }

    public Todo() {
        task = "Buy Milk";
        priority = "high";
        isTheTaskDone = true;
    }

    public boolean isTheTaskDone() {
        return isTheTaskDone;
    }


    @Override
    public void printAllFields() {
        System.out.println("Task: " + task + " | Priority: " + priority + " | Done: " + isTheTaskDone());
    }
}
