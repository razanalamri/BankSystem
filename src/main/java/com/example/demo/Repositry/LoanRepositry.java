package com.example.demo.Repositry;

import com.example.demo.Models.Customer;
import com.example.demo.Models.Loan;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepositry extends CrudRepository<Loan,Integer> {
}
