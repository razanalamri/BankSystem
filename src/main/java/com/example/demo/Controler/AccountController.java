package com.example.demo.Controler;

import com.example.demo.Models.Account;
import com.example.demo.Services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "account" )
public class AccountController {

    @Autowired
    AccountServices accountServices;


    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Account> getAllAccounts(){
        List<Account> accounts = accountServices.getAllAccounts();
        return accounts;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Account getById(@RequestParam Integer id){
        Account account=accountServices.getById(id);
        return account;
    }

    @RequestMapping(value = "getByBalance", method = RequestMethod.GET)
    public Account getByBalance(@RequestParam Double balance){
        Account account=accountServices.getByBalance(balance);
        return account;
    }


    @RequestMapping(value = "getByAccountNumber", method = RequestMethod.GET)
    public Account getByAccountNumber(@RequestParam  long accountNumber){
        Account account=accountServices.getByAccountNumber(accountNumber);
        return account;

    }

    @RequestMapping(value = "getAccountByCustomerId", method = RequestMethod.GET)
    public List<Account> getAccountByCustomerId(@RequestParam Integer id){
        List<Account> accounts=accountServices.getAccountByCustomerId(id);
        return accounts;
    }

    @RequestMapping(value = "getAllActive", method = RequestMethod.GET)
    public List<Account> getAllActive(){
        List <Account> accounts = accountServices.getAllActive();
        return accounts;
    }
    @RequestMapping(value = "getAllInActive", method = RequestMethod.GET)
    public List<Account> getAllInActive(){
        List <Account> accounts = accountServices.getAllInActive();
        return accounts;
    }

    @RequestMapping(value = "getByCreatedDate", method = RequestMethod.GET)
    public Account getByCreatedDate(@RequestParam java.sql.Date createdDate){
        Account account=accountServices.getByCreatedDate(createdDate);
        return account;
    }

    @RequestMapping(value = "getByUpdatedDate", method = RequestMethod.GET)
    public Account getByUpdatedDate(@RequestParam java.sql.Date updatedDate){
        Account account=accountServices.getByUpdatedDate(updatedDate);
        return account;
    }

    @RequestMapping(value = "createAccount", method = RequestMethod.POST)
    public void createAccount(@RequestParam long accountNumber, Double balance,int id) {
        accountServices.createAccount(accountNumber,balance,id);
    }


}
