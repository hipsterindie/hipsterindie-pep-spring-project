package com.example.exception;

public class MessageDoesNotExistException extends RuntimeException{
    public MessageDoesNotExistException(String message){
        super(message);
    }
}
