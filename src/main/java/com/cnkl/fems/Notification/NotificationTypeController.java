package com.cnkl.fems.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/notificationType")
public class NotificationTypeController {
    @Autowired
    private NotificationTypeService notificationTypeService;
    @GetMapping
    public List<NotificationType> getAllNotificationTypes(){
        return notificationTypeService.getAllNotificationTypes();
    }
}