package com.bank.business_backend.dto;

import com.bank.business_backend.entity.ContentType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateContentRequest {
    private String title;
    private String body;
    private ContentType type;
    private Long createdByUserId;
}
