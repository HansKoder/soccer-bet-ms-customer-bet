package com.hans.soccer.bet.mscustomerbet.strategies;

import com.hans.soccer.bet.mscustomerbet.documents.CustomerBet;
import com.hans.soccer.bet.mscustomerbet.enums.Status;
import com.hans.soccer.bet.mscustomerbet.models.BetResult;
import com.hans.soccer.bet.mscustomerbet.repositories.CustomerBetRepository;
import com.hans.soccer.bet.mscustomerbet.services.CustomerBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ChangeToCancelled implements ChangeStatus{

    @Autowired
    private CustomerBetRepository repository;

    private final String ABANDON_THE_BET = "ABANDON THE BET";

    private final String MESSAGE_SUCCESS = "Status change to CANCELLED with successful";

    @Override
    public Status getStatus() {
        return Status.CANCELLED;
    }

    @Override
    public ChangeStatusResponse updated(CustomerBet customerBet) {
        if (!customerBet.getStatus().equals(Status.PLAY)) {
            String msg = "Customer Bet with the ID " + customerBet.getId() + " cannot update because its status is different to PLAY";
            return new ChangeStatusResponse
                    .ChangeStatusResponseBuilder()
                    .setCodeError(HttpStatus.BAD_REQUEST)
                    .setError(msg)
                    .build();
        }

        BetResult betResult = new BetResult.BetResultBuilder()
                .addWonTheBet(Boolean.FALSE)
                .addComment(ABANDON_THE_BET)
                .build();

        customerBet.setStatus(Status.CANCELLED);
        customerBet.setBetResult(betResult);

        repository.save(customerBet);

        return new ChangeStatusResponse
                .ChangeStatusResponseBuilder()
                .setMessageUpdated(MESSAGE_SUCCESS)
                .build();
    }
}
