package com.example.demo.Repositry;

import com.example.demo.Models.Account;
import com.example.demo.Models.CreditCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CreditCardRepositry extends CrudRepository<CreditCard,Integer> {

    @Query("SELECT s from CreditCard s")
    List<CreditCard> getAll();

    @Query(value="SELECT s from CreditCard s where s.id = :id ")
    CreditCard getById(@Param("id")Integer id);

    @Query(value="SELECT s from CreditCard s where s.creditLimit = :creditLimit")
    CreditCard getByCreditLimit(@Param("creditLimit")Double creditLimit);

    @Query(value="SELECT s from CreditCard s where s.cardNumber = :cardNumber")
    CreditCard getByCreditCardNumber(@Param("cardNumber") long cardNumber);


    @Query(value = "SELECT s from CreditCard s WHERE s.account.id = :id ")
    List<CreditCard> getCreditCardByAccountId(@Param("id") Integer id);


    @Query(value="SELECT s from CreditCard s where s.createdDate = :createdDate")
    CreditCard getByCreatedDate(@Param("createdDate") Date createdDate);

    @Query(value="SELECT s from CreditCard s where s.updatedDate = :updatedDate")
    CreditCard getByUpdatedDate(@Param("updatedDate") Date updatedDate);

    @Query(value="SELECT s from CreditCard s where s.isActive =True")
    List<CreditCard> getAllActive();

    @Query(value="SELECT s from CreditCard s where s.isActive =False")
    List<CreditCard> getAllInActive();
}




