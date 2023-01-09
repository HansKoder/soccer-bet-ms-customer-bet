package com.hans.soccer.bet.mscustomerbet.strategies;

import com.hans.soccer.bet.mscustomerbet.documents.CustomerBet;
import com.hans.soccer.bet.mscustomerbet.enums.Status;

public interface ChangeStatus {

    Status getStatus();

    ChangeStatusResponse updated(CustomerBet customerBet);

}
