package com.bank.business_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    private MessageSender sender;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;

    private Boolean escalationTriggered;

    private Double satisfactionScore;

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();

        if (escalationTriggered == null) {
            escalationTriggered = false;
        }
    }
}
