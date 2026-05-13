package com.bank.business_backend.repository;

import com.bank.business_backend.entity.Content;
import com.bank.business_backend.entity.ContentStatus;
import com.bank.business_backend.entity.ContentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {

    List<Content> findByType(ContentType type);

    List<Content> findByStatus(ContentStatus status);
}
