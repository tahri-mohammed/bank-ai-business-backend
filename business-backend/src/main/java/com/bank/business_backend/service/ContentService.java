package com.bank.business_backend.service;

import com.bank.business_backend.dto.CreateContentRequest;
import com.bank.business_backend.entity.*;
import com.bank.business_backend.repository.ContentRepository;
import com.bank.business_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.bank.business_backend.client.FastApiKnowledgeClient;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;
    private final UserRepository userRepository;
    private final FastApiKnowledgeClient fastApiKnowledgeClient;
    public Content createContent(CreateContentRequest request) {
        User user = userRepository.findById(request.getCreatedByUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Content content = Content.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .type(request.getType())
                .status(ContentStatus.DRAFT)
                .createdBy(user)
                .build();

        return contentRepository.save(content);
    }

    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    public Content getContentById(Long id) {
        return contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found"));
    }

    public Content publishContent(Long id) {
    Content content = getContentById(id);
    content.setStatus(ContentStatus.PUBLISHED);

    Content savedContent = contentRepository.save(content);

    fastApiKnowledgeClient.sendContentToKnowledgeBase(savedContent);

    return savedContent;
}
}
