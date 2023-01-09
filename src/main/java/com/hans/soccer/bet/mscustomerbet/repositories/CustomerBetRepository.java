package com.hans.soccer.bet.mscustomerbet.repositories;

import com.hans.soccer.bet.mscustomerbet.documents.CustomerBet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerBetRepository extends MongoRepository<CustomerBet, String> {

    @Query("{ 'customer.document' : ?0 }")
    List<CustomerBet> findCustomerByDocument(String document);

    @Query("{ 'prognostic.betId' : ?0 }")
    List<CustomerBet> findPrognosticByBetId(String betId);

}
