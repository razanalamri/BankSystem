package com.example.demo.Services;

import com.example.demo.Models.Account;
import com.example.demo.Models.Transaction;
import com.example.demo.Repositry.TransactionRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServices {
    @Autowired
    TransactionRepositry transactionRepositry;
    public List<Transaction> getAllTransactions() {
        return transactionRepositry.getAllTransactions();
    }

    public Double getTransactionsAmountByAccountId(Integer id) {
        Double transaction = transactionRepositry.getTransactionsAmountByAccountId(id);
        return transaction;
    }




}
