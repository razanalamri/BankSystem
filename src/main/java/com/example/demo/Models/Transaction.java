package com.example.demo.Models;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@Table(name = "account_transaction")
public class Transaction extends BaseEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;
    Double amount;
    Date transactionDate;

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    Double fees;


    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @ManyToOne
    @JoinColumn(name = "creditCard_id", referencedColumnName = "id")
    CreditCard creditCard;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    Account account;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
