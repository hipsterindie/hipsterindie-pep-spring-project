package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

    //for user story #3
    public Optional<Message> findByPostedBy(int postedBy);

    //for user story #7
    public void updateMessageTextById(String messageText, int messageId);

    //for user story #8
    public List<Message> findAllByAccountId(int accountId);

}
