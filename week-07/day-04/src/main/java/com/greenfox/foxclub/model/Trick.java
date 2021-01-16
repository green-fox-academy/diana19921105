package com.greenfox.foxclub.model;

public enum Trick {
    WRITE_HTML("Write HTML"),
    CODE_IN_JAVA("Code in Java"),
    SIT("Sit"),
    STAY("Stay"),
    SPEAK("Speak"),
    GIVE_ME_A_PAWN("Give me a pawn"),
    ROLL_OVER("Roll over"),
    SLEEP("Sleep"),
    PLAY_TAG("Play with me tag");

    private String name;

    Trick(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
