package com.hans.soccer.bet.mscustomerbet.models;

public class BetResult {

    private Double payment;

    private Boolean wonTheBet;

    private String comment;

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Boolean getWonTheBet() {
        return wonTheBet;
    }

    public void setWonTheBet(Boolean wonTheBet) {
        this.wonTheBet = wonTheBet;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BetResult (BetResultBuilder builder) {
        this.payment = builder.payment;
        this.wonTheBet = builder.wonTheBet;
        this.comment = builder.comment;
    }

    public BetResult() {
    }

    public static class BetResultBuilder {
        private Double payment;

        private Boolean wonTheBet;

        private String comment;

        public BetResultBuilder addPayment(Double payment) {
            this.payment = payment;
            return this;
        }

        public BetResultBuilder addWonTheBet(Boolean wonTheBet) {
            this.wonTheBet = wonTheBet;
            return this;
        }

        public BetResultBuilder addComment(String comment) {
            this.comment = comment;
            return this;
        }

        public BetResult build () {
            return new BetResult(this);
        }
    }
}
