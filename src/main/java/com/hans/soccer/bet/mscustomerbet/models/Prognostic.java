package com.hans.soccer.bet.mscustomerbet.models;

import com.hans.soccer.bet.mscustomerbet.enums.Winner;

public class Prognostic {

    private String betId;

    private Winner winner;

    public Prognostic(String betId, Winner winner) {
        this.betId = betId;
        this.winner = winner;
    }

    public String getBetId() {
        return betId;
    }

    public void setBetId(String betId) {
        this.betId = betId;
    }

    public Winner getWinner() {
        return winner;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }
}
