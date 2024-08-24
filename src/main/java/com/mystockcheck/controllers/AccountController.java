package com.mystockcheck.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mystockcheck.models.Accounts;
import com.mystockcheck.models.AccountsRepository;


import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AccountController {
    
    @Autowired
    private AccountsRepository accountsRepo;

    @PostMapping("/register")
    public String register(@RequestParam Map<String, String> newAccount) {
        System.out.println("registering new account");
        String newUserName = newAccount.get("username");
        System.out.println("Saving account: " + newUserName);
        String newPassword = newAccount.get("password");
        accountsRepo.save(new Accounts(newUserName, newPassword));
        return "/homepage";
    }
}

