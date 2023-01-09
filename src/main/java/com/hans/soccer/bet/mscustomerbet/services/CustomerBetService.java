package com.hans.soccer.bet.mscustomerbet.services;

import com.hans.soccer.bet.mscustomerbet.documents.CustomerBet;
import com.hans.soccer.bet.mscustomerbet.enums.Status;
import com.hans.soccer.bet.mscustomerbet.strategies.ChangeStatusResponse;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CustomerBetService {

    CustomerBet save(CustomerBet entity);

    List<CustomerBet> findAll ();

    Optional<CustomerBet> findCustomerBetId (String customerBetId);

    List<CustomerBet> findCustomerBetsByCustomer(String customer);
    List<CustomerBet> findCustomerBetsByBet(String betId);

    Optional<ChangeStatusResponse> updateStatus (CustomerBet customerBet, Status status);

}
