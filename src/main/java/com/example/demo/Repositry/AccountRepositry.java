package com.example.demo.Repositry;

import com.example.demo.Models.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AccountRepositry extends CrudRepository<Account,Integer> {

    @Query("SELECT s from Account s")
    List<Account> getAllAccounts();
    @Query(value="SELECT s from Account s where s.id = :id ")
    Account getById(@Param("id")Integer id);

    @Query(value="SELECT s from Account s where s.balance = :balance")
    Account getByBalance(@Param("balance")Double balance);

    @Query(value="SELECT s from Account s where s.accountNumber = :accountNumber")
    Account getByAccountNumber(@Param("accountNumber") long accountNumber);


    @Query(value = "SELECT s from Account s WHERE s.customer.id = :id ")
    List<Account> getAccountByCustomerId(@Param("id") Integer id);


    @Query(value="SELECT s from Account s where s.createdDate = :createdDate")
    Account getByCreatedDate(@Param("createdDate") Date createdDate);

    @Query(value="SELECT s from Account s where s.updatedDate = :updatedDate")
    Account getByUpdatedDate(@Param("updatedDate") Date updatedDate);

    @Query(value="SELECT s from Account s where s.isActive =True")
    List<Account> getAllActive();

    @Query(value="SELECT s from Account s where s.isActive =False")
    List<Account> getAllInActive();

    @Query(value="SELECT s.balance from Account s where s.id = :id")
    Double getBalance(@Param("id") Integer id);





}


