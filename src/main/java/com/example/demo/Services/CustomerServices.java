package com.example.demo.Services;

import com.example.demo.DTO.AccountSummaryObject;
import com.example.demo.DTO.CustomerAccountDetailsObject;
import com.example.demo.Models.Account;
import com.example.demo.Models.CreditCard;
import com.example.demo.Models.Customer;
import com.example.demo.Repositry.AccountRepositry;
import com.example.demo.Repositry.CustomerRepositry;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class CustomerServices {

    @Autowired
    CustomerRepositry customerRepositry;

    @Autowired
    AccountRepositry accountRepositry;

    public static final String pathToReports = "C:\\Users\\user012\\Downloads\\Reports";


    public List<Customer> getAll() {
        return customerRepositry.getAll();
    }

//    public Customer getByCustomerName(String name) {
//        Customer customer = customerRepositry.getByCustomerName(name);
//        return customer;
//
//    }
    public Customer getByCustomerEmail(String email) {
        Customer customer = customerRepositry.getByCustomerEmail(email);
        return customer;
    }

    public List<Customer> getAllActive() {
        return customerRepositry.getAllActive();
    }

    public List<Customer> getAllInActive() {
        return customerRepositry.getAllInActive();
    }

    public Customer getByCreatedDate(Date createdDate) {
        Customer customer = customerRepositry.getByCreatedDate(createdDate);
        return customer;
    }

    public Customer getByUpdatedDate(Date updatedDate) {
        Customer customer = customerRepositry.getByUpdatedDate(updatedDate);
        return customer;
    }

    public Customer getById(Integer id) {
        Customer customer = customerRepositry.getById(id);
        return customer;
    }

    public void createCustomer(String email,String name, String phoneNumber) {
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setName(name);
        customer.setPhoneNumber(phoneNumber);
        customer.setActive(true);
        customer.setCreatedDate(new Date());
        customerRepositry.save(customer);
    }

    public void updateCustomer(Integer id,String phoneNumber, String email){
        Customer customer =customerRepositry.getById(id);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);
        customerRepositry.save(customer);
    }

    public Customer getCustomerAccountDetails(Integer id) {
        Customer customer = customerRepositry.getById(id);
        return customer;
    }


    public String getCustomerAccountDetails () throws FileNotFoundException, JRException {
        List<Account> accounts = accountRepositry.getAllAccounts();
        List<CustomerAccountDetailsObject> customerAccountDetailsObjects = new ArrayList<>();
        for (Account account : accounts) {
            String name = account.getCustomer().getName();
            long accountNumber =account.getAccountNumber();
            Double balance = account.getBalance();
            CustomerAccountDetailsObject customerAccountDetailsObject = new CustomerAccountDetailsObject(name, accountNumber, balance);
            customerAccountDetailsObjects.add(customerAccountDetailsObject);
        }

        File file = ResourceUtils.getFile("classpath:CustomerAccountDetails.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        var dataSource = new JRBeanCollectionDataSource(customerAccountDetailsObjects);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Razan");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\CustomerDetails.pdf");
        return "Report generated : " + pathToReports + "\\CustomerDetails.pdf";


    }
}
