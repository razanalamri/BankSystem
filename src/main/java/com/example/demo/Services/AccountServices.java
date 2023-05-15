package com.example.demo.Services;


import com.example.demo.DTO.AccountHistoryObject;
import com.example.demo.DTO.AccountSummaryObject;
import com.example.demo.Models.Account;
import com.example.demo.Models.Transaction;
import com.example.demo.Repositry.AccountRepositry;
import com.example.demo.Repositry.TransactionRepositry;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class AccountServices {
    @Autowired
    AccountRepositry accountRepositry;

    @Autowired
    CustomerServices customerServices;

    @Autowired
    TransactionRepositry transactionRepositry;

    public static final String pathToReports = "C:\\Users\\user012\\Downloads\\Reports";

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


        }
        return accountRepositry.getBalance(id);


    }

    public void getIntrset() {
        List<Account> accountList = accountRepositry.getAllAccounts();
        for (Account account : accountList) {
            Double balance = account.getBalance();
            Double interestPercent = 0.5;
            Double interestAmount = balance * interestPercent;
            account.setInterest(interestAmount);
            accountRepositry.save(account);

        } }

        public String generateReportForAccountSummary () throws FileNotFoundException, JRException {
            List<Account> accounts = accountRepositry.getAllAccounts();
            List<AccountSummaryObject> accountSummaryObjects = new ArrayList<>();
            for (Account account : accounts) {
                String name = account.getCustomer().getName();
                long accountNumber = account.getAccountNumber();
                Double balance = account.getBalance();
                Double intrset=account.getInterest();
                AccountSummaryObject accountSummaryObject = new AccountSummaryObject(name, accountNumber, balance,intrset);
                accountSummaryObjects.add(accountSummaryObject);
            }

            File file = ResourceUtils.getFile("classpath:AccountSummary.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            var dataSource = new JRBeanCollectionDataSource(accountSummaryObjects);
            Map<String, Object> paramters = new HashMap<>();
            paramters.put("CreatedBy", "Razan");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Accounts.pdf");
            return "Report generated : " + pathToReports + "\\Accounts.pdf";


        }


    public String generateReportForAccountHistory () throws FileNotFoundException, JRException {
        List<Transaction> transactions = transactionRepositry.getAllTransactions();
        List<AccountHistoryObject> accountHistoryObjects = new ArrayList<>();
        for (Transaction transaction : transactions) {
            long accountNumber=transaction.getAccount().getAccountNumber();
            Date transactionDate=transaction.getTransactionDate();
            Double amount=transaction.getAmount();
            Double balance=transaction.getAccount().getBalance();
            AccountHistoryObject accountHistoryObject = new AccountHistoryObject(accountNumber, transactionDate, amount,balance);
            accountHistoryObjects.add(accountHistoryObject);
        }

        File file = ResourceUtils.getFile("classpath:AccountHistory.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        var dataSource = new JRBeanCollectionDataSource(accountHistoryObjects);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Razan");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\History.pdf");
        return "Report generated : " + pathToReports + "\\History.pdf";


    }


    }























