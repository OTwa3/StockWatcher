package com.mystockcheck.mystockcheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mystockcheck.mystockcheck.models.Accounts;
import com.mystockcheck.mystockcheck.models.AccountsRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AccountsRepository accountsRepository;

  
  public UserDetailsServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }


@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    System.out.println("Username: " + username);
    Accounts user = accountsRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
}

@SuppressWarnings("deprecation")
@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); 
    }

}

