package com.bank.business_backend.repository;

import com.bank.business_backend.entity.AuditLog;
import com.bank.business_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByUser(User user);
}
