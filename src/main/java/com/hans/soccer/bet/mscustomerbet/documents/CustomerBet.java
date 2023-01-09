package com.hans.soccer.bet.mscustomerbet.documents;

import com.hans.soccer.bet.mscustomerbet.enums.Status;
import com.hans.soccer.bet.mscustomerbet.models.Customer;
import com.hans.soccer.bet.mscustomerbet.models.Prognostic;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CustomerBets")
public class CustomerBet {

    @Id
    private String id;

    private Customer customer;

    private Prognostic prognostic;

    private Double betPayment;

    private Status status;

    public CustomerBet() {
        this.status = Status.PLAY;
    }

    public CustomerBet(String id, Customer customer, Prognostic prognostic, Double betPayment) {
        this.id = id;
        this.customer = customer;
        this.prognostic = prognostic;
        this.betPayment = betPayment;
        this.status = Status.PLAY;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Prognostic getPrognostic() {
        return prognostic;
    }

    public void setPrognostic(Prognostic prognostic) {
        this.prognostic = prognostic;
    }

    public Double getBetPayment() {
        return betPayment;
    }

    public void setBetPayment(Double betPayment) {
        this.betPayment = betPayment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
