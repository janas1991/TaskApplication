package com.kodilla.rps;

public class Player {

    private final String name;
    private String move;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getMove() {
        return move;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
