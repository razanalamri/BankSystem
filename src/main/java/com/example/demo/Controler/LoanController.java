package com.example.demo.Controler;

import com.example.demo.Services.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "loan" )
public class LoanController {
    @Autowired
    LoanServices loanServices;



    @RequestMapping(value = "createNewLoan", method = RequestMethod.POST)
    public void createNewLoan(@RequestParam int id ,Double amount,Boolean isActive) {
        loanServices.createNewLoan(id,amount,isActive);
    }
}
