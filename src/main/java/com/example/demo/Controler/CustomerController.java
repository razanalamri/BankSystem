package com.example.demo.Controler;

import com.example.demo.Models.CreditCard;
import com.example.demo.Models.Customer;
import com.example.demo.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value= "customer" )
public class CustomerController {

    @Autowired
    CustomerServices customerServices;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Customer> getAll(){
        List<Customer> customers = customerServices.getAll();
        return customers;
    }


//    @RequestMapping(value = "getByCustomerName", method = RequestMethod.GET)
//    public Customer getByCustomerName(@RequestParam String name){
//        Customer customer=customerServices.getByCustomerName(name);
//        return customer;
//    }

    @RequestMapping(value = "getByCustomerEmail", method = RequestMethod.GET)
    public Customer getByCustomerEmail(@RequestParam  String email){
        Customer customer=customerServices.getByCustomerEmail(email);
        return customer;

    }

    @RequestMapping(value = "getAllActive", method = RequestMethod.GET)
    public List<Customer> getAllActive(){
        List <Customer> customers = customerServices.getAllActive();
        return customers;
    }
    @RequestMapping(value = "getAllInActive", method = RequestMethod.GET)
    public List<Customer> getAllInActive(){
        List <Customer> customers = customerServices.getAllInActive();
        return customers;
    }

    @RequestMapping(value = "getByCreatedDate", method = RequestMethod.GET)
    public Customer getByCreatedDate(@RequestParam java.sql.Date createdDate){
        Customer customer=customerServices.getByCreatedDate(createdDate);
        return customer;
    }

    @RequestMapping(value = "getByUpdatedDate", method = RequestMethod.GET)
    public Customer getByUpdatedDate(@RequestParam java.sql.Date updatedDate){
        Customer customer=customerServices.getByUpdatedDate(updatedDate);
        return customer;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Customer getById(@RequestParam Integer id){
        Customer customer=customerServices.getById(id);
        return customer;
    }


}
