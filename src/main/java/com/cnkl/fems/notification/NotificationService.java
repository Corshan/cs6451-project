package com.cnkl.fems.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    private NotificationRepository notificationRepository;
    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }
    public void deleteNotificationById(Long id) {
        notificationRepository.deleteById(id);
    }
}