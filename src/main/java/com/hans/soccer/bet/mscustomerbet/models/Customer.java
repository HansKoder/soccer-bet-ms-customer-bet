package com.hans.soccer.bet.mscustomerbet.models;

public class Customer {
    private String fullName;
    private String document;

    public Customer(String fullName, String document) {
        this.fullName = fullName;
        this.document = document;
    }

    public Customer() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
