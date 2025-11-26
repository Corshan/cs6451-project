package com.cnkl.fems.notification;

import com.cnkl.fems.ticket.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingObserver implements TicketPurchaseObserver {
    private static final Logger log = LoggerFactory.getLogger(LoggingObserver.class);

    @Override
    public void onTicketPurchased(Ticket ticket) {
        log.info("TICKET PURCHASED | Customer: {} | Festival: {} | Price: {}",
                ticket.getCustomer().getName(),
                ticket.getFestival().getName(),
                ticket.getTotalPrice());
    }
}