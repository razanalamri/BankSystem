package com.example.demo.Services;

import com.example.demo.DTO.TransactionsWithinSpecificTimePeriodObject;
import com.example.demo.Models.Transaction;
import com.example.demo.Repositry.TransactionRepositry;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.data.jpa.domain.AbstractAuditable_.createdDate;

@Service
public class TransactionServices {
    @Autowired
    TransactionRepositry transactionRepositry;

    @Autowired
    AccountServices accountServices;

    public static final String pathToReports = "C:\\Users\\user012\\Downloads\\Reports";

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

    public void calculateTransactionFees() {
        List<Transaction> transactionList = transactionRepositry.getAllTransactions();
        for (Transaction transaction : transactionList) {
            Double amount = transaction.getAmount();
            Double feesPercent = 0.5;
            Double fees = amount * feesPercent;
            transaction.setFees(fees);
            transactionRepositry.save(transaction);

        }}



        public String generateReportOfTransactionsWithinSpecificTimePeriod() throws  FileNotFoundException, JRException {
            List<Transaction> transactions = transactionRepositry.getAllTransactions();
            List<TransactionsWithinSpecificTimePeriodObject> transactionsWithinSpecificTimePeriodObjects = new ArrayList<>();

            for (Transaction transaction : transactions) {
                String name = transaction.getAccount().getCustomer().getName();
                long accountNumber=transaction.getAccount().getAccountNumber();
                Double amount=transaction.getAmount();
                Date transactionDate=transaction.getTransactionDate();
                TransactionsWithinSpecificTimePeriodObject transactionsWithinSpecificTimePeriodObject = new TransactionsWithinSpecificTimePeriodObject(name,accountNumber, amount,transactionDate);
                transactionsWithinSpecificTimePeriodObjects.add(transactionsWithinSpecificTimePeriodObject);
            }

            File file = ResourceUtils.getFile("classpath:TransactionsReport.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            var dataSource = new JRBeanCollectionDataSource(transactionsWithinSpecificTimePeriodObjects);
            Map<String, Object> paramters = new HashMap<>();
            paramters.put("CreatedBy", "Razan");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Transaction.pdf");
            return "Report generated : " + pathToReports + "\\Transaction.pdf";
            }

            }




