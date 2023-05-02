package com.example.demo.Repositry;

import com.example.demo.Models.CreditCard;
import com.example.demo.Models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepositry extends CrudRepository<Customer,Integer> {

    @Query(value="SELECT s from Customer s where s.id = :id ")
    Customer getById(@Param("id")Integer id);
}
