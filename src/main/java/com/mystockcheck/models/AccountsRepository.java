package com.mystockcheck.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts,Integer> {
    List<Accounts> findByUsername(String username);
    List<Accounts> findByPassword(String password);
}





