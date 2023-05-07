package com.example.demo.Services;


import com.example.demo.Models.Account;
import com.example.demo.Models.Transaction;
import com.example.demo.Repositry.AccountRepositry;
import com.example.demo.Repositry.CustomerRepositry;
import com.example.demo.Repositry.TransactionRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public class AccountServices {
    @Autowired
    AccountRepositry accountRepositry;

    @Autowired
    CustomerServices customerServices;

    @Autowired
    TransactionRepositry transactionRepositry;

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
    }

    public void createAccount(long accountNumber, Double balance, int id) {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);
        account.setActive(true);
        account.setCreatedDate(new Date());
        account.setCustomer(customerServices.getById(id));
        accountRepositry.save(account);
    }

    public Double getBalance(Integer id) {
        Double account = accountRepositry.getBalance(id);
        return account;
    }

    public Double UpdateTheBalanceAfterTransactions(Integer id) {
        List<Account> accountList = accountRepositry.getAllAccounts();
        for (Account account : accountList) {
            Double transactionalAmount = transactionRepositry.getTransactionsAmountByAccountId(id);
            Double AccountBalance = account.getBalance();
            Double newBalance = AccountBalance - transactionalAmount;
            account.setBalance(newBalance);
            accountRepositry.save(account);


    } return accountRepositry.getBalance(id);


    }

    public void getIntrset(Integer id) {
        List<Account> accountList = accountRepositry.getAllAccounts();
        for (Account account : accountList) {
            Double balance = accountRepositry.getBalance(id);
            Double interestPercent = 0.5;
            Double interestAmount = balance * interestPercent;
            account.setInterest(interestAmount);
            accountRepositry.save(account);

        }



}}























