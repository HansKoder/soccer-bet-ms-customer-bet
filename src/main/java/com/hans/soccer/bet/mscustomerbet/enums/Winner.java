package com.hans.soccer.bet.mscustomerbet.enums;

public enum Winner {

    TEAM_A("TEAM_A"),
    TEAM_B("TEAM_B"),
    NONE("NONE");

    private String name;

    public String getName() {
        return name;
    }

    Winner(String name) {
        this.name = name;
    }

}
