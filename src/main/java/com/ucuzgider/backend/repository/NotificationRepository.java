package com.ucuzgider.backend.repository;

import com.ucuzgider.backend.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> { }
