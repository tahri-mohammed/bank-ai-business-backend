package com.bank.business_backend.controller;

import com.bank.business_backend.dto.CreateContentRequest;
import com.bank.business_backend.entity.Content;
import com.bank.business_backend.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contents")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @PostMapping
    public Content createContent(@RequestBody CreateContentRequest request) {
        return contentService.createContent(request);
    }

    @GetMapping
    public List<Content> getAllContents() {
        return contentService.getAllContents();
    }

    @GetMapping("/{id}")
    public Content getContentById(@PathVariable Long id) {
        return contentService.getContentById(id);
    }

    @PutMapping("/{id}/publish")
    public Content publishContent(@PathVariable Long id) {
        return contentService.publishContent(id);
    }
}
