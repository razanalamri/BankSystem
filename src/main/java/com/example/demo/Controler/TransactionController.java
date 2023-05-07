package com.example.demo.Controler;

import com.example.demo.Models.Account;
import com.example.demo.Models.Transaction;
import com.example.demo.Services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value= "transaction" )
public class TransactionController {
    @Autowired
    TransactionServices transactionServices;
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Transaction> getAllAccounts(){
        List<Transaction> transactions = transactionServices.getAllTransactions();
        return transactions;
    }

    @RequestMapping(value = "getTransactionsAmountByAccountId", method = RequestMethod.GET)
    public Double getTransactionsAmountByAccountId(@RequestParam Integer id){
        Double transaction=transactionServices.getTransactionsAmountByAccountId(id);
        return transaction;
    }




}
