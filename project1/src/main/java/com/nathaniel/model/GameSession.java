package com.nathaniel.model;

public class GameSession {

    private Player p1;
    private Player p2;
    private int rounds = 10;

    public GameSession(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String playRound(Move m1, Move m2) {
        if ((m1 == Move.ROCK && m2 == Move.SCISSORS)
                || (m1 == Move.PAPER && m2 == Move.ROCK)
                || (m1 == Move.SCISSORS && m2 == Move.PAPER)) {
            p1.addWin();
            return p1.getName() + " wins the round!";
        } else {
            p2.addWin();
            return p2.getName() + " wins the round!";
        }
    }

    public Player getPlayer1() {
        return p1;
    }

    public Player getPlayer2() {
        return p2;
    }
}
