package com.example.exception;

public class UsernameIsBlankException extends RuntimeException{
    public UsernameIsBlankException(String message){
        super(message);
    }
}