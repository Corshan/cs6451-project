package com.cnkl.fems.notification;

import com.cnkl.fems.ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    private NotificationRepository notificationRepository;

    private final List<TicketPurchaseObserver> observers = new ArrayList<>();

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, List<TicketPurchaseObserver> observers) {
        this.notificationRepository = notificationRepository;
        this.observers.addAll(observers); // Auto-injects all observers
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

    public void notifyTicketPurchased(Ticket ticket) {
        for (TicketPurchaseObserver observer : observers) {
            observer.onTicketPurchased(ticket);
        }
    }
}