package com.example.demo.Controler;

import com.example.demo.Models.Account;
import com.example.demo.Models.Transaction;
import com.example.demo.Services.TransactionServices;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
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
    @RequestMapping(value = "getTransactionsByAccountId", method = RequestMethod.GET)
    public List<Transaction> getTransactionsByAccountId(@RequestParam Integer id){
        List<Transaction> transaction=transactionServices.getTransactionsByAccountId(id);
        return transaction;
    }

    @RequestMapping(value = "createNewTransaction", method = RequestMethod.POST)
    public void createNewTransaction(@RequestParam int id, Double amount,Boolean isActive) {
        transactionServices.createNewTransaction(id,amount,isActive);
    }

    @RequestMapping(value = "getFees", method = RequestMethod.POST)
    public void calculateTransactionFees(){
   transactionServices.calculateTransactionFees();

    }


    @RequestMapping(value="generateReportOfTransactionsWithinSpecificTimePeriod",method = RequestMethod.GET)
    public String generateReportOfTransactionsWithinSpecificTimePeriod() throws JRException, FileNotFoundException {
        return transactionServices.generateReportOfTransactionsWithinSpecificTimePeriod();
    }




}
