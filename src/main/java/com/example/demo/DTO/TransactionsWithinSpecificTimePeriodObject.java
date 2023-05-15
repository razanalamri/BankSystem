package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class  TransactionsWithinSpecificTimePeriodObject {

    String name;
    long accountNumber;
    Double amount;

    public TransactionsWithinSpecificTimePeriodObject(String name, long accountNumber, Double amount, Date transactionDate) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    Date transactionDate;

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }









}
