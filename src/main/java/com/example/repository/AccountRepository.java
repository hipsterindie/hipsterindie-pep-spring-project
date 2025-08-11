package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

    //For user story #1 & #2
    public Optional<Account> findByUsername(String username);

    //for user story #2
    public Optional<Account> findByUsernameAndPassword(String username, String password);

}
