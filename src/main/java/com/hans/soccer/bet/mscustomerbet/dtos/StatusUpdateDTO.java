package com.hans.soccer.bet.mscustomerbet.dtos;

import com.hans.soccer.bet.mscustomerbet.enums.Status;

public class StatusUpdateDTO {

    private String customerBetId;

    private Status status;

    public StatusUpdateDTO(String customerBetId, Status status) {
        this.customerBetId = customerBetId;
        this.status = status;
    }

    public StatusUpdateDTO() {
    }

    public String getCustomerBetId() {
        return customerBetId;
    }

    public void setCustomerBetId(String customerBetId) {
        this.customerBetId = customerBetId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
