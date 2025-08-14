package com.example.exception;

public class MessageIsTooLongException extends RuntimeException{
    public MessageIsTooLongException(String message){
        super(message);
    }
}
