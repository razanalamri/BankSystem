package com.example.demo.Repositry;

import com.example.demo.Models.CreditCard;
import com.example.demo.Models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CustomerRepositry extends CrudRepository<Customer,Integer> {

    @Query("SELECT s from Customer s")
    List<Customer> getAll();


//    @Query(value="SELECT s from Customer s where s.name =:name")
//    Customer getByCustomerName(@Param("cardNumber") String name);

    @Query(value="SELECT s from Customer s where s.email = :email")
    Customer getByCustomerEmail(@Param("email") String email);


    @Query(value="SELECT s from Customer s where s.createdDate = :createdDate")
    Customer getByCreatedDate(@Param("createdDate") Date createdDate);

    @Query(value="SELECT s from Customer s where s.updatedDate = :updatedDate")
    Customer getByUpdatedDate(@Param("updatedDate") Date updatedDate);

    @Query(value="SELECT s from Customer s where s.isActive =True")
    List<Customer> getAllActive();

    @Query(value="SELECT s from Customer s where s.isActive =False")
    List<Customer> getAllInActive();

    @Query(value="SELECT s from Customer s where s.id = :id ")
    Customer getById(@Param("id")Integer id);
}
