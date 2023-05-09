package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CustomerAccountDetailsObject {
    String name;
    long accountNumber;
    Double balance;

    public CustomerAccountDetailsObject(String name, long accountNumber, Double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }



}
