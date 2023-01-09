package com.hans.soccer.bet.mscustomerbet.services;

import com.hans.soccer.bet.mscustomerbet.documents.CustomerBet;

import java.util.List;
import java.util.Optional;

public interface CustomerBetService {

    CustomerBet save(CustomerBet entity);

    List<CustomerBet> findAll ();

    Optional<CustomerBet> findCustomerBetId (String customerBetId);

    List<CustomerBet> findCustomerBetsByCustomer(String customer);
    List<CustomerBet> findCustomerBetsByBet(String betId);

}
