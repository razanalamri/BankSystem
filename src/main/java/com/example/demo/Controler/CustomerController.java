package com.example.demo.Controler;

import com.example.demo.Models.CreditCard;
import com.example.demo.Models.Customer;
import com.example.demo.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value= "customer" )
public class CustomerController {

    @Autowired
    CustomerServices customerServices;
    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Customer getById(@RequestParam Integer id){
        Customer customer=customerServices.getById(id);
        return customer;
    }


}
