package com.nathaniel.model;

public enum Move {
    ROCK,
    PAPER,
    SCISSORS;

    public static Move fromInt(int choice) {
        switch (choice) {
            case 0:
                return ROCK;
            case 1:
                return PAPER;
            case 2:
                return SCISSORS;
            default:
                return null;
        }
    }
}
