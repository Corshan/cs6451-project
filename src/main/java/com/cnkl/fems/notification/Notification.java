package com.cnkl.fems.notification;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne
    private NotificationType notificationType;
    public Notification(String message, NotificationType notificationType) {
        this.message = message;
        this.notificationType = notificationType;
    }
    public Notification() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public NotificationType getNotificationType() {
        return notificationType;
    }
    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }
}