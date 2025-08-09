package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.exception.PasswordTooShortException;
import com.example.exception.UsernameAlreadyExistsException;
import com.example.exception.UsernameIsBlankException;
import com.example.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

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

}
