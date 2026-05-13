package com.bank.business_backend.controller;

import com.bank.business_backend.dto.CreateConversationRequest;
import com.bank.business_backend.entity.Conversation;
import com.bank.business_backend.service.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversations")
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;

    @PostMapping
    public Conversation createConversation(@RequestBody CreateConversationRequest request) {
        return conversationService.createConversation(request);
    }

    @GetMapping
    public List<Conversation> getAllConversations() {
        return conversationService.getAllConversations();
    }

    @GetMapping("/{id}")
    public Conversation getConversationById(@PathVariable Long id) {
        return conversationService.getConversationById(id);
    }
}
