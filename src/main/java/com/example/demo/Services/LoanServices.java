package com.example.demo.Services;

import com.example.demo.Models.Account;
import com.example.demo.Models.Loan;
import com.example.demo.Repositry.LoanRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoanServices {
    @Autowired
    LoanRepositry loanRepositry;
    @Autowired
    CustomerServices customerServices;



    public void createNewLoan(int id,Double amount, Boolean isActive) {
        Loan loan = new Loan();
        loan.setAmount(amount);
        loan.setActive(true);
        loan.setCreatedDate(new Date());
        loan.setCustomer(customerServices.getById(id));
        loanRepositry.save(loan);
    }
}
