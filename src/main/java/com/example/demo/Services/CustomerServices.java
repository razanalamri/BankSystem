package com.example.demo.Services;

import com.example.demo.Models.CreditCard;
import com.example.demo.Models.Customer;
import com.example.demo.Repositry.CustomerRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServices {

    @Autowired
    CustomerRepositry customerRepositry;

    public List<Customer> getAll() {
        return customerRepositry.getAll();
    }

//    public Customer getByCustomerName(String name) {
//        Customer customer = customerRepositry.getByCustomerName(name);
//        return customer;
//
//    }
    public Customer getByCustomerEmail(String email) {
        Customer customer = customerRepositry.getByCustomerEmail(email);
        return customer;
    }

    public List<Customer> getAllActive() {
        return customerRepositry.getAllActive();
    }

    public List<Customer> getAllInActive() {
        return customerRepositry.getAllInActive();
    }

    public Customer getByCreatedDate(Date createdDate) {
        Customer customer = customerRepositry.getByCreatedDate(createdDate);
        return customer;
    }

    public Customer getByUpdatedDate(Date updatedDate) {
        Customer customer = customerRepositry.getByUpdatedDate(updatedDate);
        return customer;
    }

    public Customer getById(Integer id) {
        Customer customer = customerRepositry.getById(id);
        return customer;
    }
}
