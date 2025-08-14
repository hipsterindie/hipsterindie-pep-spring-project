package com.example.exception;

public class MessageIsBlankException extends RuntimeException {
    public MessageIsBlankException(String message){
        super(message);
    }
}
