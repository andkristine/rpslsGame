package com.games;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        int handsWon = 0;
        int handsLost = 0;
        int matchesWon = 0;
        int gameCounter = 1;

        Computer computer = new Computer();
        Scanner scanner = new Scanner(System.in);
        
        Player player1 = new Player("Mr. I-Mean-Business");
        Player player2 = new Player("Yellow Snowman");
        Player player3 = new Player("Apple Bottom Jeans");

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        System.out.println("Get ready for a game of ROCK PAPER SCISSORS LIZARD SPOCK!");
        System.out.println("To become the true winner of the championship, you have to beat three players, three rounds each.");
        System.out.println("Good luck!");
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-");

        for (Player player : players) {

            String playerName = player.getName();
            System.out.println("Prepare to battle with " + playerName + "!");

            for (int i = 0; i < 3; i++) {

                String playerMove;
                String computerMove = computer.getComputerMove();

                while (true) {
                    System.out.println("Make your move ( rock / paper / scissors / lizard / spock ): ");
                    playerMove = scanner.nextLine();
                    if (playerMove.equals(Move.ROCK.getValue()) || playerMove.equals(Move.PAPER.getValue()) || playerMove.equals(Move.SCISSORS.getValue()) || playerMove.equals(Move.LIZARD.getValue()) || playerMove.equals(Move.SPOCK.getValue())) {
                        break;
                    }
                    System.out.println(playerMove + " is not a valid move.");
                }

                System.out.println(player.getName() + " put " + computerMove);

                String result = compareMoves(playerMove, computerMove);
                String resultMessage = "";

                switch (result) {
                    case "T":
                        resultMessage = "You had a tie!";
                        break;
                    case "L":
                        resultMessage = "Opponent has the winning hand!";
                        handsLost++;
                        break;
                    case "W":
                        resultMessage = "You have the winning hand!";
                        handsWon++;
                        break;
                }
                System.out.println(resultMessage);
            }

            System.out.print("Round " + gameCounter + " has ended. ");
            gameCounter++;

            if (handsWon == handsLost) {
                System.out.println("It is a tie!");
            } else if (handsWon > handsLost) {
                System.out.println("You have won the round against " + playerName + "!");
                matchesWon++;
            } else if (handsWon < handsLost) {
                System.out.println(playerName + " has won this round!");
            }

            System.out.println("_-_-_-_-_-_-_-_-_-_-_-");
        }

        System.out.println("The tournament has ended.");

        if (matchesWon == 3) {
            System.out.println("You are the winner of tournament! Congratulations!");
        } else {
            System.out.println("Sorry, you weren't successful in beating all the players. Better luck next time!");
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
