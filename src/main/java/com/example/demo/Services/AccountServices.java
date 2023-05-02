package com.example.demo.Services;


import com.example.demo.Models.Account;
import com.example.demo.Repositry.AccountRepositry;
import com.example.demo.Repositry.CustomerRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountServices {
    @Autowired
    AccountRepositry accountRepositry;

    public List<Account> getAllAccounts() {
        return accountRepositry.getAllAccounts();
    }

    public Account getById(Integer id) {
        Account account = accountRepositry.getById(id);
        return account;
    }

    public Account getByBalance(Double balance) {
        Account account = accountRepositry.getByBalance(balance);
        return account;

    }

    public Account getByAccountNumber(long accountNumber) {
        Account account = accountRepositry.getByAccountNumber(accountNumber);
        return account;

    }

    public List<Account> getAccountByCustomerId(Integer id) {
        List<Account> accounts = accountRepositry.getAccountByCustomerId(id);
        return accounts;
    }


    public List<Account> getAllActive() {
        return accountRepositry.getAllActive();
    }

    public List<Account> getAllInActive() {
        return accountRepositry.getAllInActive();
    }

    public Account getByCreatedDate(Date createdDate) {
        Account account = accountRepositry.getByCreatedDate(createdDate);
        return account;
    }

    public Account getByUpdatedDate(Date updatedDate) {
        Account account = accountRepositry.getByUpdatedDate(updatedDate);
        return account;
    }}




