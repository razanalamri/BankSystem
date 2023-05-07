package com.example.demo.Controler;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "general" )
public class GeneralController {

    @GetMapping(value = "/testForUser")
    @PreAuthorize("hasRole('USER')")
    public String testForUser(){
        return "it works for user";
    }

    @GetMapping(value = "/testForAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String testForAdmin(){
        return "it works for admin";
    }


}
