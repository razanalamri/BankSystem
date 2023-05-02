package com.example.demo.Services;

import com.example.demo.Models.Account;
import com.example.demo.Models.CreditCard;
import com.example.demo.Repositry.CreditCardRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CreditCardServices {

    @Autowired
    CreditCardRepositry creditCardRepositry;
    public List<CreditCard> getAll() {
        return creditCardRepositry.getAll();
    }

    public CreditCard getById(Integer id) {
        CreditCard creditCard = creditCardRepositry.getById(id);
        return creditCard;
    }

    public CreditCard getByCreditLimit(Double creditLimit) {
        CreditCard creditCard = creditCardRepositry.getByCreditLimit(creditLimit);
        return creditCard;

    }

    public CreditCard getByCreditCardNumber(long cardNumber) {
        CreditCard creditCard = creditCardRepositry.getByCreditCardNumber(cardNumber);
        return creditCard;

    }

    public List<CreditCard> getAccountByCustomerId(Integer id) {
        List<CreditCard> creditCards = creditCardRepositry.getCreditCardByAccountId(id);
        return creditCards;
    }


    public List<CreditCard> getAllActive() {
        return creditCardRepositry.getAllActive();
    }

    public List<CreditCard> getAllInActive() {
        return creditCardRepositry.getAllInActive();
    }

    public CreditCard getByCreatedDate(Date createdDate) {
        CreditCard creditCard = creditCardRepositry.getByCreatedDate(createdDate);
        return creditCard;
    }

    public CreditCard getByUpdatedDate(Date updatedDate) {
        CreditCard creditCard = creditCardRepositry.getByUpdatedDate(updatedDate);
        return creditCard;
    }}












