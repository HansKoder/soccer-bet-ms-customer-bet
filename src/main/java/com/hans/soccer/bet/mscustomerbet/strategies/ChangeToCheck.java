package com.hans.soccer.bet.mscustomerbet.strategies;

import com.hans.soccer.bet.mscustomerbet.documents.CustomerBet;
import com.hans.soccer.bet.mscustomerbet.enums.Status;
import com.hans.soccer.bet.mscustomerbet.enums.Winner;
import com.hans.soccer.bet.mscustomerbet.models.BetResult;
import com.hans.soccer.bet.mscustomerbet.models.Prognostic;
import com.hans.soccer.bet.mscustomerbet.repositories.CustomerBetRepository;
import com.hans.soccer.bet.mscustomerbet.services.CustomerBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ChangeToCheck implements ChangeStatus{

    @Autowired
    private CustomerBetRepository repository;

    private final String WON_BET = "WON THE BET";
    private final String LOST_BET = "LOST THE BET";

    @Override
    public Status getStatus() {
        return Status.CHECK;
    }

    @Override
    public ChangeStatusResponse updated(CustomerBet customerBet) {
        if (!customerBet.getStatus().equals(Status.PROCESS)) {
            String msg = "Customer Bet with the ID " + customerBet.getId() + " cannot update because its status is different to PROCESS";
            return new ChangeStatusResponse
                    .ChangeStatusResponseBuilder()
                    .setCodeError(HttpStatus.BAD_REQUEST)
                    .setError(msg)
                    .build();
        }

        customerBet.setStatus(Status.CHECK);
        customerBet.setBetResult(buildBetResult(customerBet));

        repository.save(customerBet);

        return new ChangeStatusResponse
                .ChangeStatusResponseBuilder()
                .setMessageUpdated("Status change to CHECK with successful")
                .build();
    }

    private Boolean winnerTheBet (Prognostic prognostic) {
        // this is temporal
        if (prognostic.getWinner().equals(Winner.TEAM_A)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    private Double calculatePayment (Double betPayment, Double percentage) {
        return betPayment * percentage;
    }

    private BetResult buildBetResult (CustomerBet customerBet) {
        if (winnerTheBet(customerBet.getPrognostic())) {
            return new BetResult.BetResultBuilder()
                    .addWonTheBet(Boolean.TRUE)
                    .addPayment(calculatePayment(customerBet.getBetPayment(), 1.5D))
                    .addComment(WON_BET)
                    .build();
        }

        return new BetResult.BetResultBuilder()
                .addWonTheBet(Boolean.FALSE)
                .addComment(LOST_BET)
                .build();
    }
}
