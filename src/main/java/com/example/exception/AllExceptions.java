package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllExceptions{

    //user story #1
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
    
    //user story #2
    @ExceptionHandler(UsernameOrPasswordIsInvalidException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handleUsernameOrPasswordInvalid(UsernameOrPasswordIsInvalidException ex){
        return ex.getMessage();
    }

    //user story #3
    @ExceptionHandler(MessageIsBlankException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMessageIsBlank(MessageIsBlankException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(MessageIsTooLongException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMessageIsTooLong(MessageIsTooLongException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleUserNotFound(UserNotFoundException ex){
        return ex.getMessage();
    }

    //user story #7
    @ExceptionHandler(MessageDoesNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMessageDoesNotExist(MessageDoesNotExistException ex){
        return ex.getMessage();
    }

}
