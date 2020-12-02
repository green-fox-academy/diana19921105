package com.greenfox.postit;

public class Main {
    public static void main(String[] args) {
        PostIt postItOrange = new PostIt();
        postItOrange.backgroundColor = "orange";
        postItOrange.textColor = "blue";
        postItOrange.text = "Idea-1";

        PostIt postItPink = new PostIt();
        postItPink.backgroundColor = "pink";
        postItOrange.textColor = "black";
        postItOrange.text = "Awesome";

        PostIt postItYellow = new PostIt();
        postItYellow.backgroundColor = "yellow";
        postItYellow.textColor = "green";
        postItYellow.text = "Superb!";
    }
}
