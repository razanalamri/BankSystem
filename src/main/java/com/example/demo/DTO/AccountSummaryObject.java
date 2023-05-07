package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AccountSummaryObject {

    public AccountSummaryObject(String name, long accountNumber, Double balance, Double intrset) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.intrset = intrset;


    }

    String name;
    long accountNumber;
    Double balance;
    Double intrset;

}
