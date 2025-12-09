package com.cnkl.fems.notification;

import com.cnkl.fems.ticket.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationObserver implements TicketPurchaseObserver {
    private static final Logger log = LoggerFactory.getLogger(EmailNotificationObserver.class);
    private final TicketService ticketService;

    @Autowired
    public EmailNotificationObserver(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public void onTicketPurchased(Ticket ticket) {
        String email = ticket.getCustomer().getEmail();
        String subject = "Ticket Purchased - " + ticket.getFestival().getName();
        String body = String.format("""
            Dear %s,
            Your ticket for %s has been successfully purchased!
            Ticket ID: %d
            Type: %s
            Price: %.2f
            Thank you!
            """, ticket.getCustomer().getName(),
                ticket.getFestival().getName(),
                ticket.getId(),
                ticket.getTicketType(),
                ticketService.calculatePrice(ticket));

        // In real app: integrate with JavaMailSender or external service
        log.info("EMAIL SENT to {}: {}", email, subject);
        System.out.println("Email sent to: " + email);
    }
}