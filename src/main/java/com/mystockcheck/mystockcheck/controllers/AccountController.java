package com.mystockcheck.mystockcheck.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;



import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.mystockcheck.mystockcheck.models.Accounts;
import com.mystockcheck.mystockcheck.models.AccountsRepository;




@Controller
public class AccountController {

    public AccountController() {
        System.out.println("AccountController()");
    }

    
    
    @Autowired
    private AccountsRepository accountsRepo;

    @PostMapping("/register") 
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        System.out.println("registering new account");
        Accounts account = new Accounts(username, password);
        accountsRepo.save(account);
        return "title"; 
    }

   @GetMapping("/register")
    public String register() {
        System.out.println("register()");
        return "register";
    }

    
    

   
}

