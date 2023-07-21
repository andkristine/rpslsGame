package com.games;

import java.util.Random;

public class Computer {

    public String getComputerMove() {

        Random random = new Random();
        int randomNumber = random.nextInt(5);
        String computerMove = Move.values()[randomNumber].getValue();

        return computerMove;

    }
}