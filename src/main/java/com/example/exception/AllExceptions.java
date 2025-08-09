package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllExceptions{

    @ExceptionHandler(PasswordTooShortException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlePasswordShort(PasswordTooShortException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUsernameTaken(UsernameAlreadyExistsException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(UsernameIsBlankException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleUsernameBlank(UsernameIsBlankException ex){
        return ex.getMessage();
    }

}
