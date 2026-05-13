package com.bank.business_backend.controller;

import com.bank.business_backend.dto.SendMessageRequest;
import com.bank.business_backend.entity.Message;
import com.bank.business_backend.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public Message sendMessage(@RequestBody SendMessageRequest request) {
        return messageService.sendClientMessage(request);
    }

    @GetMapping("/conversation/{conversationId}")
    public List<Message> getMessagesByConversation(@PathVariable Long conversationId) {
        return messageService.getMessagesByConversation(conversationId);
    }
}
