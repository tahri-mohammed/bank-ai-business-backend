package com.bank.business_backend.service;

import com.bank.business_backend.dto.CreateConversationRequest;
import com.bank.business_backend.entity.Conversation;
import com.bank.business_backend.entity.User;
import com.bank.business_backend.repository.ConversationRepository;
import com.bank.business_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConversationService {

    private final ConversationRepository conversationRepository;
    private final UserRepository userRepository;

    public Conversation createConversation(CreateConversationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Conversation conversation = Conversation.builder()
                .title(request.getTitle())
                .user(user)
                .build();

        return conversationRepository.save(conversation);
    }

    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }

    public Conversation getConversationById(Long id) {
        return conversationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conversation not found"));
    }
}
