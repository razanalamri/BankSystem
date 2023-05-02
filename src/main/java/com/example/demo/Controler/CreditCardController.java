package com.example.demo.Controler;

import com.example.demo.Models.Account;
import com.example.demo.Models.CreditCard;
import com.example.demo.Services.CreditCardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "creditcard" )
public class CreditCardController {

    @Autowired
    CreditCardServices creditCardServices;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<CreditCard> getAll(){
        List<CreditCard> creditCards = creditCardServices.getAll();
        return creditCards;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public CreditCard getById(@RequestParam Integer id){
        CreditCard creditcard=creditCardServices.getById(id);
        return creditcard;
    }

    @RequestMapping(value = "getByCreditLimit", method = RequestMethod.GET)
    public CreditCard getByCreditLimit(@RequestParam Double creditLimit){
        CreditCard creditcard=creditCardServices.getByCreditLimit(creditLimit);
        return creditcard;
    }


    @RequestMapping(value = "getByCreditCardNumber", method = RequestMethod.GET)
    public CreditCard getByCreditCardNumber(@RequestParam  long cardNumber){
        CreditCard creditcard=creditCardServices.getByCreditCardNumber(cardNumber);
        return creditcard;

    }

    @RequestMapping(value = "getCreditCardByAccountId", method = RequestMethod.GET)
    public List<CreditCard> getAccountByCustomerId(@RequestParam Integer id){
        List<CreditCard> creditcards=creditCardServices.getAccountByCustomerId(id);
        return creditcards;
    }

    @RequestMapping(value = "getAllActive", method = RequestMethod.GET)
    public List<CreditCard> getAllActive(){
        List <CreditCard> creditcards = creditCardServices.getAllActive();
        return creditcards;
    }
    @RequestMapping(value = "getAllInActive", method = RequestMethod.GET)
    public List<CreditCard> getAllInActive(){
        List <CreditCard> creditCards = creditCardServices.getAllInActive();
        return creditCards;
    }

    @RequestMapping(value = "getByCreatedDate", method = RequestMethod.GET)
    public CreditCard getByCreatedDate(@RequestParam java.sql.Date createdDate){
        CreditCard creditcard=creditCardServices.getByCreatedDate(createdDate);
        return creditcard;
    }

    @RequestMapping(value = "getByUpdatedDate", method = RequestMethod.GET)
    public CreditCard getByUpdatedDate(@RequestParam java.sql.Date updatedDate){
        CreditCard creditcard=creditCardServices.getByUpdatedDate(updatedDate);
        return creditcard;
    }
}
