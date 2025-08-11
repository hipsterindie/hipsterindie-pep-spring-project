package com.example.exception;

public class UsernameOrPasswordIsInvalidException extends RuntimeException{
    public UsernameOrPasswordIsInvalidException(String message){
        super(message);
    }
}
