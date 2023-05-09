package com.example.demo.Repositry;

import com.example.demo.Models.Customer;
import com.example.demo.Models.Loan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LoanRepositry extends CrudRepository<Loan,Integer> {



    @Query(value="SELECT s.isActive from Loan s where s.customer.id = :id")
    Boolean getLoanStatus(@Param("id") Integer id);
}
