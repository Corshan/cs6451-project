package com.cnkl.fems.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationTypeService {
    private NotificationTypeRepository notificationTypeRepository;
    @Autowired
    public NotificationTypeService(NotificationTypeRepository notificationTypeRepository) {
        this.notificationTypeRepository = notificationTypeRepository;
    }
    public List<NotificationType> getAllNotificationTypes() {
        return notificationTypeRepository.findAll();
    }
    public Optional<NotificationType> getNotificationTypeById(Long id) {
        return notificationTypeRepository.findById(id);
    }
    public NotificationType createNotificationType(NotificationType notificationType) {
        return notificationTypeRepository.save(notificationType);
    }
    public void deleteNotificationTypeById(Long id) {
        notificationTypeRepository.deleteById(id);
    }
}