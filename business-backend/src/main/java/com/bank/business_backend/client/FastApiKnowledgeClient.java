package com.bank.business_backend.client;

import com.bank.business_backend.entity.Content;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class FastApiKnowledgeClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String FASTAPI_URL =
            "http://127.0.0.1:8000/api/knowledge/contents";

    public void sendContentToKnowledgeBase(Content content) {
        Map<String, String> request = Map.of(
                "title", content.getTitle(),
                "body", content.getBody(),
                "content_type", content.getType().name()
        );

        restTemplate.postForObject(
                FASTAPI_URL,
                request,
                String.class
        );
    }
}
