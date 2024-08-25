package com.mystockcheck.mystockcheck.models;

import java.util.Optional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;


public interface AccountsRepository extends JpaRepository<Accounts,Integer> {
   Optional<Accounts> findByUsername(String username);
    Optional <Accounts> findByPassword(String password);
}





