package com.games;

public enum Move {

    ROCK("rock"),
    PAPER("paper"),
    SCISSORS("scissors"),
    LIZARD("lizard"),
    SPOCK("spock");

    private final String value;

    Move (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
