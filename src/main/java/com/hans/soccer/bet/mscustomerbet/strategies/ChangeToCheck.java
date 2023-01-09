package com.hans.soccer.bet.mscustomerbet.strategies;

import com.hans.soccer.bet.mscustomerbet.documents.CustomerBet;
import com.hans.soccer.bet.mscustomerbet.enums.Status;
import org.springframework.stereotype.Component;

@Component
public class ChangeToCheck implements ChangeStatus{
    @Override
    public Status getStatus() {
        return Status.CHECK;
    }

    @Override
    public ChangeStatusResponse updated(CustomerBet customerBet) {
        return new ChangeStatusResponse
                .ChangeStatusResponseBuilder()
                .setMessageUpdated("Status change to CHECK with successful")
                .build();
    }
}
