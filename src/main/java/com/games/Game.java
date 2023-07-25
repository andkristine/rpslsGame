package com.games;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Computer computer = new Computer();

    public static void main(String[] args) {

        int matchesWon = 0;
        int gameCounter = 1;

        final Player player1 = new Player("Mr. I-Mean-Business");
        final Player player2 = new Player("Yellow Snowman");
        final Player player3 = new Player("Apple Bottom Jeans");

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        players.add(new Player("knsd"));

        System.out.println("_-_-_-_-_-_-_-_-_-_-_-");
        System.out.println("Get ready for a game of ROCK PAPER SCISSORS LIZARD SPOCK!");
        System.out.println("To become the true winner of the championship, you have to beat three players, three rounds each.");
        System.out.println("Good luck!");
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-");

        for (Player player : players) {

            int handsWon = 0;
            int handsLost = 0;

            String playerName = player.getName();
            System.out.println("Prepare to battle with " + playerName + "!");

            for (int i = 0; i < 3; i++) {

                String computerMove = computer.getComputerMove();
                String playerMove = validatePlayerMove();
                System.out.println(player.getName() + " put " + computerMove + ".");
                boolean isPlayerWon = isPlayerWon(playerMove, computerMove);

                String resultMessage = "";
                if (isPlayerWon) {
                    resultMessage = "You have the winning hand!";
                    ++handsWon;
                } else {
                    resultMessage = "Opponent has the winning hand!";
                    ++handsLost;
                }

                System.out.println(resultMessage);
            }

            if (handsWon > handsLost) {
                System.out.println("You have won the round against " + playerName + "!");
                matchesWon++;
            } else {
                System.out.println(playerName + " has won this round!");
            }

            System.out.print("Round " + gameCounter + " has ended. ");
            System.out.println("After round " + gameCounter + " you have " + matchesWon + " wins.");
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-");
            gameCounter++;
        }

        System.out.println("The tournament has ended.");

        if (matchesWon == 3) {
            System.out.println("You are the winner of the tournament! Congratulations!");
        } else {
            System.out.println("Sorry, you weren't successful in beating all the players. Better luck next time!");
        }
    }

    public static String validatePlayerMove() {

        String playerMove;

        while (true) {
            System.out.println("Make your move ( rock / paper / scissors / lizard / spock ): ");
            playerMove = scanner.nextLine();
            if (playerMove.equals(Move.ROCK.getValue()) || playerMove.equals(Move.PAPER.getValue()) || playerMove.equals(Move.SCISSORS.getValue()) || playerMove.equals(Move.LIZARD.getValue()) || playerMove.equals(Move.SPOCK.getValue())) {
                break;
            }
            System.out.println(playerMove + " is not a valid move.");
        }

        return playerMove;
    }

    public static boolean isPlayerWon(String playerMove, String computerMove) {

        boolean isPlayerWon = true;

        while (true) {
            if (playerMove.equals(computerMove)) {
                System.out.println("You had a tie! Players, please make your moves again: ");
                playerMove = validatePlayerMove();
                computerMove = computer.getComputerMove();
                System.out.println("Opponent put " + computerMove + ".");
            } else {
                break;
            }
        }

        if (playerMove.equals(Move.ROCK.getValue())) {
            if (computerMove.equals(Move.PAPER.getValue()) || computerMove.equals(Move.SPOCK.getValue())) {
                isPlayerWon = false;
            }
        } else if (playerMove.equals(Move.SCISSORS.getValue())) {
            if (computerMove.equals(Move.ROCK.getValue()) || computerMove.equals(Move.SPOCK.getValue())) {
                isPlayerWon = false;
            }
        } else if (playerMove.equals(Move.PAPER.getValue())) {
            if (computerMove.equals(Move.SCISSORS.getValue()) || computerMove.equals(Move.LIZARD.getValue())) {
                isPlayerWon = false;
            }
        } else if (playerMove.equals(Move.LIZARD.getValue())) {
            if (computerMove.equals(Move.ROCK.getValue()) || computerMove.equals(Move.SCISSORS.getValue())) {
                isPlayerWon = false;
            }
        } else if (playerMove.equals(Move.SPOCK.getValue())) {
            if (computerMove.equals(Move.PAPER.getValue()) || computerMove.equals(Move.LIZARD.getValue())) {
                isPlayerWon = false;
            }
        }

        return isPlayerWon;
    }
}
