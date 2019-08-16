package com.kodilla.rps;

public class Computer {

    private final String name;
    private int move;
    private int score;

    public Computer(String name) {
        this.name = name;
    }

    public int setMove(int move) {
        this.move = move;
        return move;
    }

    public int getMove() {
        return move;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }


}
