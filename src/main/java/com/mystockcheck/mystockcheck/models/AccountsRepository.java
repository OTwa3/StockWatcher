package com.mystockcheck.mystockcheck.models;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;



public interface AccountsRepository extends JpaRepository<Accounts,Integer> {
   Optional<Accounts> findByUsername(String username);
    Optional <Accounts> findByPassword(String password);
}





