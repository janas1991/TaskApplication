package com.kodilla.rps;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.util.Random;
import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {

        Player player = new Player("Bernadeta");
        Computer computer = new Computer("Michał");
        Scanner scanner = new Scanner(System.in);
        Random computerGenerator = new Random();

        String tmpMove = "";
        int tmpPlayerScore = 0;
        int tmpComputerScore = 0;
        System.out.println("Hello , let's play in PRS");
        while (tmpComputerScore < 6 || tmpPlayerScore < 6) {

            int computerMove = computer.setMove(computerGenerator.nextInt(3) + 1);
            if (computerMove == 1) {
                tmpMove = "P";
            } else if (computerMove == 2) {
                tmpMove = "R";
            } else if (computerMove == 3) {
                tmpMove = "S";
            }

            System.out.println(player.getName() + " It's your move");

            player.setMove(scanner.next().toUpperCase());

            if (!(player.getMove().equals("P") || player.getMove().equals("R") || player.getMove().equals("S"))) {
                throw new IllegalArgumentException("You should choose beetween 'P,R,S'");
            }

            System.out.println("Computer play is: ");
            System.out.println(tmpMove);

            boolean end = false;
            if (player.getMove().equals(tmpMove)) {
                System.out.println("It's a tie!");
                tmpComputerScore++;
                tmpPlayerScore++;
            } else if (player.getMove().equals("R") && tmpMove.equals("S")) {
                System.out.println("Rock crushes scissors. You win!!");
                tmpPlayerScore++;
            } else if (player.getMove().equals("R") && tmpMove.equals("P")) {
                System.out.println("Paper destroy Stone. You lose!!");
                tmpComputerScore++;
            } else if (player.getMove().equals("P") && tmpMove.equals("R")) {
                System.out.println("Paper destroy Stone. You win!!");
                tmpPlayerScore++;
            } else if (player.getMove().equals("P") && tmpMove.equals("S")) {
                System.out.println("Scissor cuts paper. You lose");
                tmpComputerScore++;
            } else if (player.getMove().equals("S") && tmpMove.equals("R")) {
                System.out.println("Rock crushes scissors. You lose!!");
                tmpComputerScore++;
            } else if (player.getMove().equals("S") && tmpMove.equals("P")) {
                System.out.println("Scissor cuts paper. You win");
                tmpPlayerScore++;
            } else {
                System.out.println("Invalid user input.");
            }
            player.setScore(tmpPlayerScore);
            computer.setScore(tmpComputerScore);
            System.out.println( computer.getName() + " score = " + tmpComputerScore + " vs " + player.getName() +" score = " + tmpPlayerScore);
            System.out.println(" ");
            System.out.println("------------------------------------");
            if (player.getScore() == 5) {
                System.out.println(player.getName() + " win !!!!");
                break;
            }
            if (computer.getScore() == 5) {
                System.out.println(computer.getName() + " win !!!!");
                break;
            }

        }
    }
}
