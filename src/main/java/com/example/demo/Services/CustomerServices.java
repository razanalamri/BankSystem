package com.example.demo.Services;

import com.example.demo.Models.CreditCard;
import com.example.demo.Models.Customer;
import com.example.demo.Repositry.CustomerRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServices {

    @Autowired
    CustomerRepositry customerRepositry;

    public Customer getById(Integer id) {
        Customer customer = customerRepositry.getById(id);
        return customer;
    }
}
