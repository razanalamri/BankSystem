package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Data
@Getter
@Setter
public class AccountHistoryObject {

    long accountNumber;
    Date transactionDate;
    Double amount;
    Double balance;


    public AccountHistoryObject(long accountNumber, Date transactionDate, Double amount, Double balance) {
        this.accountNumber = accountNumber;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.balance = balance;
    }


}
