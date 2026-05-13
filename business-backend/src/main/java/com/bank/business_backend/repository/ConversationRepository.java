package com.bank.business_backend.repository;

import com.bank.business_backend.entity.Conversation;
import com.bank.business_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findByUser(User user);
}
