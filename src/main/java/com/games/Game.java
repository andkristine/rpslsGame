package com.games;

import java.util.Scanner;

public class Game {

    public static void main (String[] args) {

        int playerWin = 0;
        int playerLose = 0;
        Computer computer = new Computer();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {

            String playerMove;
            String computerMove = computer.getComputerMove();

            while (true) {
                System.out.println("Please enter your move ( rock / paper / scissors / lizard / spock ): ");
                playerMove = scanner.nextLine();
                if (playerMove.equals(Move.ROCK.getValue()) || playerMove.equals(Move.PAPER.getValue()) || playerMove.equals(Move.SCISSORS.getValue()) || playerMove.equals(Move.LIZARD.getValue()) || playerMove.equals(Move.SPOCK.getValue())) {
                    break;
                }
                System.out.println(playerMove + " is not a valid move.");
            }

            System.out.println("Computer put " + computerMove);

            String result = compareMoves(playerMove, computerMove);
            String resultMessage = "";

            switch (result) {
                case "T":
                    resultMessage = "You had a tie!";
                    break;
                case "L":
                    resultMessage = "Computer has the winning hand!";
                    playerLose++;
                    break;
                case "W":
                    resultMessage = "You have the winning hand!";
                    playerWin++;
                    break;
            }

            System.out.println(resultMessage);
            System.out.println(playerLose);
            System.out.println(playerWin);
        }

        System.out.println("_-_-_-_-_-_-_-_-_-_-_-");
        System.out.print("The game has ended. ");
        if (playerWin == playerLose) {
            System.out.println("It is a tie!");
        } else if (playerWin > playerLose) {
            System.out.println("You are the true champion!");
        } else if (playerWin < playerLose) {
            System.out.println("Computer has won!");
        }

    }

    public static String compareMoves(String playerMove, String computerMove) {

        String result = "";

        if (playerMove.equals(computerMove)) {
            result = "T";
        } else if (playerMove.equals(Move.ROCK.getValue())) {
            if (computerMove.equals(Move.PAPER.getValue()) || computerMove.equals(Move.SPOCK.getValue())) {
                result = "L";
            } else if (computerMove.equals(Move.SCISSORS.getValue()) || computerMove.equals(Move.LIZARD.getValue())) {
                result = "W";
            }
        } else if (playerMove.equals(Move.SCISSORS.getValue())) {
            if (computerMove.equals(Move.ROCK.getValue()) || computerMove.equals(Move.SPOCK.getValue())) {
                result = "L";
            } else if (computerMove.equals(Move.PAPER.getValue()) || computerMove.equals(Move.LIZARD.getValue())) {
                result = "W";
            }
        } else if (playerMove.equals(Move.PAPER.getValue())) { 
            if (computerMove.equals(Move.SCISSORS.getValue()) || computerMove.equals(Move.LIZARD.getValue())) {
                result = "L";
            } else if (computerMove.equals(Move.ROCK.getValue()) || computerMove.equals(Move.SPOCK.getValue())) {
                result = "W";
            }
        } else if (playerMove.equals(Move.LIZARD.getValue())) {
            if (computerMove.equals(Move.ROCK.getValue()) || computerMove.equals(Move.SCISSORS.getValue())) {
                result = "L";
            } else if (computerMove.equals(Move.PAPER.getValue()) || computerMove.equals(Move.SPOCK.getValue())) {
                result = "W";
            }
        } else if (playerMove.equals(Move.SPOCK.getValue())) {
            if (computerMove.equals(Move.PAPER.getValue()) || computerMove.equals(Move.LIZARD.getValue())) {
                result = "L";
            } else if (computerMove.equals(Move.SCISSORS.getValue()) || computerMove.equals(Move.ROCK.getValue())) {
                result = "W";
            }
        }

        return result;
    }
}
