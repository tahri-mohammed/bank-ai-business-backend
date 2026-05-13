package com.bank.business_backend.repository;

import com.bank.business_backend.entity.Conversation;
import com.bank.business_backend.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByConversation(Conversation conversation);
}
