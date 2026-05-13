package com.bank.business_backend.service;

import com.bank.business_backend.dto.SendMessageRequest;
import com.bank.business_backend.entity.Conversation;
import com.bank.business_backend.entity.Message;
import com.bank.business_backend.entity.MessageSender;
import com.bank.business_backend.repository.ConversationRepository;
import com.bank.business_backend.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final ConversationRepository conversationRepository;

    public Message sendClientMessage(SendMessageRequest request) {
        Conversation conversation = conversationRepository.findById(request.getConversationId())
                .orElseThrow(() -> new RuntimeException("Conversation not found"));

        Message message = Message.builder()
                .conversation(conversation)
                .content(request.getContent())
                .sender(MessageSender.CLIENT)
                .build();

        return messageRepository.save(message);
    }

    public List<Message> getMessagesByConversation(Long conversationId) {
        Conversation conversation = conversationRepository.findById(conversationId)
                .orElseThrow(() -> new RuntimeException("Conversation not found"));

        return messageRepository.findByConversation(conversation);
    }
}
