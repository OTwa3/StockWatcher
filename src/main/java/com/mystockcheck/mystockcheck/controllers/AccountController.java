package com.mystockcheck.mystockcheck.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mystockcheck.mystockcheck.models.Accounts;
import com.mystockcheck.mystockcheck.models.AccountsRepository;

import org.springframework.web.bind.annotation.RequestMethod;



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

