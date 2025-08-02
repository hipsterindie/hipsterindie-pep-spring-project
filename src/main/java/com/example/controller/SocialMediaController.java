package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {


    private final AccountService accountService;

    @Autowired
    public SocialMediaController(AccountService accountService){
        this.accountService = accountService;
    }

/*
 * ## 1: Our API should be able to process new User registrations.
 * As a user, I should be able to create a new Account on the endpoint POST localhost:8080/register.
 * The body will contain a representation of a JSON Account, but will not contain an accountId.
 * 
 * - The registration will be successful if and only if the username is not blank, the password is at least 4 characters long,
 *   and an Account with that username does not already exist. 
 *   If all these conditions are met, the response body should contain a JSON of the Account, including its accountId. 
 *   The response status should be 200 OK, which is the default. The new account should be persisted to the database.
 * - If the registration is not successful due to a duplicate username, the response status should be 409. (Conflict)
 * - If the registration is not successful for some other reason, the response status should be 400. (Client error)
 */

    @PostMapping("/register")
    public @ResponseBody Account registerAccount(@RequestBody Account account){

        //confused on how Spring Boot calls a service...
        Account registeredAccount = accountService.registerAccount(account);    //to-do: write this method

        return registeredAccount;

    }

    //maybe add a "usernameInUseException" method here. not sure if the application should throw an exception? maybe not for now.
    //to-do: write this method/handler. as well as the one in the AccountService. as well as the ones in the AccountRepo...


}
