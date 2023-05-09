package com.example.demo.Services;

import com.example.demo.Models.Transaction;
import com.example.demo.Repositry.TransactionRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class TransactionServices {
    @Autowired
    TransactionRepositry transactionRepositry;

    @Autowired
    AccountServices accountServices;

    @Autowired
    CreditCardServices creditCardServices;
    public List<Transaction> getAllTransactions() {
        return transactionRepositry.getAllTransactions();
    }

    public Double getTransactionsAmountByAccountId(Integer id) {
        Double transaction = transactionRepositry.getTransactionsAmountByAccountId(id);
        return transaction;
    }

    public void createNewTransaction(int id, Double amount, Boolean isActive) {
        Transaction transaction = new Transaction();
        transaction.setAccount(accountServices.getById(id));
        transaction.setAmount(amount);
        transaction.setActive(true);
        transaction.setTransactionDate(new Date());
        transaction.setCreatedDate(new Date());
        transactionRepositry.save(transaction);
    }

    public List<Transaction> getTransactionsByAccountId(Integer id) {
        List<Transaction> transaction = transactionRepositry.getTransactionsByAccountId(id);
        return transaction;
    }




}
