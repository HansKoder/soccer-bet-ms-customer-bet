package com.hans.soccer.bet.mscustomerbet.services;

import com.hans.soccer.bet.mscustomerbet.documents.CustomerBet;
import com.hans.soccer.bet.mscustomerbet.enums.Status;
import com.hans.soccer.bet.mscustomerbet.repositories.CustomerBetRepository;
import com.hans.soccer.bet.mscustomerbet.strategies.ChangeStatus;
import com.hans.soccer.bet.mscustomerbet.strategies.ChangeStatusFactory;
import com.hans.soccer.bet.mscustomerbet.strategies.ChangeStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerBetServiceImpl implements CustomerBetService{

    @Autowired
    private CustomerBetRepository customerBetRepository;

    @Autowired
    private ChangeStatusFactory factory;

    @Override
    public CustomerBet save(CustomerBet entity) {
        return customerBetRepository.save(entity);
    }

    @Override
    public List<CustomerBet> findAll() {
        return customerBetRepository.findAll();
    }

    @Override
    public Optional<CustomerBet> findCustomerBetId(String customerBetId) {
        return customerBetRepository.findById(customerBetId);
    }

    @Override
    public List<CustomerBet> findCustomerBetsByCustomer(String customer) {
        return customerBetRepository.findCustomerByDocument(customer);
    }

    @Override
    public List<CustomerBet> findCustomerBetsByBet(String betId) {
        return customerBetRepository.findPrognosticByBetId(betId);
    }

    @Override
    public Optional<ChangeStatusResponse> updateStatus(CustomerBet customerBet, Status status) {
        ChangeStatus changeStatus = factory.find(status);
        return Optional.ofNullable(changeStatus.updated(customerBet));
    }
}
