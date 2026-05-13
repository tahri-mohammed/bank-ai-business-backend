package com.bank.business_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "conversations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private ConversationStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime startedAt;

    private LocalDateTime closedAt;

    @PrePersist
    public void onCreate() {
        startedAt = LocalDateTime.now();

        if (status == null) {
            status = ConversationStatus.OPEN;
        }
    }
}
