package com.example.service;

import com.example.entity.Message;
import com.example.exception.MessageDoesNotExistException;
import com.example.exception.MessageIsBlankException;
import com.example.exception.MessageIsTooLongException;
import com.example.exception.UserNotFoundException;
import com.example.repository.MessageRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    //user story #3; message text should be: not blank, ! > 255 char, and postedBy is a real, existing user. 
    public Message createMessage(Message message){
        
        if( message.getMessageText().isBlank() || message.getMessageText().isEmpty() ){
            throw new MessageIsBlankException("Message cannot be blank!");
        }

        if( message.getMessageText().length() > 255 ){
            throw new MessageIsTooLongException("Message cannot be greater than 255 characters!");
        }

        if( messageRepository.findByPostedBy(message.getPostedBy()).isEmpty() ){
            throw new UserNotFoundException("User could not be found by ID!");
        }

        return messageRepository.save(message);

    }

    //user story #4
    public List<Message> getAllMessages(){

        return messageRepository.findAll();

    }

    //user story #5
    public Message getMessageById(int messageId){

        Optional<Message> optionalMessage = messageRepository.findById(messageId);

        if(optionalMessage.isPresent()) return optionalMessage.get();
        else return null;

    }

    //user story #6
    public Integer deleteMessageById(int messageId){

        boolean messageExists = messageRepository.existsById(messageId);

        if(messageExists){
            messageRepository.deleteById(messageId);
            return 1;
        }
        else return null;

    }

    //user story #7
    public Integer patchMessageById(String messageText, int messageId){

        boolean messageExists = messageRepository.existsById(messageId);

        if(!messageExists){
            throw new MessageDoesNotExistException("Message does not exist in the database!");
        }

        if( messageText.isBlank() || messageText.isEmpty() ){
            throw new MessageIsBlankException("Message cannot be blank!");
        }

        if( messageText.length() > 255 ){
            throw new MessageIsTooLongException("Message cannot be greater than 255 characters!");
        }

        Message updateMessage = messageRepository.findById(messageId).get();

        updateMessage.setMessageText(messageText);

        messageRepository.save(updateMessage);

        return 1;

    }

    //user story #8
    public List<Message> getAllMessagesByAccountId(int accountId){

        List<Message> messagesByAccount = messageRepository.findAllByPostedBy(accountId);

        return messagesByAccount;

    }

}
