package com.cnkl.fems.notification;

import com.cnkl.fems.ticket.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationObserver implements TicketPurchaseObserver {
    private static final Logger log = LoggerFactory.getLogger(EmailNotificationObserver.class);

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
                ticket.getTotalPrice());

        // In real app: integrate with JavaMailSender or external service
        log.info("EMAIL SENT to {}: {}", email, subject);
        System.out.println("Email sent to: " + email);
    }
}