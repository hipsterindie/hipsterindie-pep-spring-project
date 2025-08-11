package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.exception.PasswordTooShortException;
import com.example.exception.UsernameAlreadyExistsException;
import com.example.exception.UsernameIsBlankException;
import com.example.exception.UsernameOrPasswordIsInvalidException;
import com.example.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    //user story #1: business logic (throws exceptions and gives specific HTTP codes)
    public Account registerAccount(Account account){

        if( account.getPassword().length() < 4 ){
            throw new PasswordTooShortException("Password provided must be 4 characters or more.");
        }

        if( account.getUsername().isEmpty() || account.getUsername().isBlank()){
            throw new UsernameIsBlankException("Username provided cannot be blank.");
        }

        if( accountRepository.findByUsername( account.getUsername() ).isPresent() ){
            throw new UsernameAlreadyExistsException("Username '" + account.getUsername() + "' is already taken.");
        }
        
        
        return accountRepository.save(account);

    }
    
    //User story #2.
    public Account loginAccount(Account account){
        if( !accountRepository.findByUsernameAndPassword(account.getUsername(), account.getPassword()).isPresent() ){

            throw new UsernameOrPasswordIsInvalidException("Username or Password entered is invalid. Try again.");

        }

        Account loggedAccount = accountRepository.findByUsernameAndPassword(account.getUsername(), account.getPassword()).get();        
        
        return loggedAccount;
    }

}
