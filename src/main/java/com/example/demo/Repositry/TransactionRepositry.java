package com.example.demo.Repositry;

import com.example.demo.Models.Account;
import com.example.demo.Models.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TransactionRepositry  extends CrudRepository<Transaction,Integer> {

    @Query("SELECT s from Transaction s")
    List<Transaction> getAllTransactions();

    @Query(value = "select m.amount from Transaction m where m.account.id = :id ")
    Double getTransactionsAmountByAccountId(@Param("id") Integer id);

    @Query(value = "select m from Transaction m where m.account.id = :id ")
    List<Transaction> getTransactionsByAccountId(@Param("id") Integer id);





}
