package com.hans.soccer.bet.mscustomerbet.dtos;

import com.hans.soccer.bet.mscustomerbet.enums.Winner;

public class PrognosticUpdateDTO {

    private String customerBetId;
    private Winner winner;

    public PrognosticUpdateDTO(String customerBetId, Winner winner) {
        this.customerBetId = customerBetId;
        this.winner = winner;
    }

    public PrognosticUpdateDTO() {
    }

    public String getCustomerBetId() {
        return customerBetId;
    }

    public void setCustomerBetId(String customerBetId) {
        this.customerBetId = customerBetId;
    }

    public Winner getWinner() {
        return winner;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }
}
