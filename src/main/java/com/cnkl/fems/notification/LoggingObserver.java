package com.cnkl.fems.notification;

import com.cnkl.fems.ticket.Ticket;
import com.cnkl.fems.ticket.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoggingObserver implements TicketPurchaseObserver {
    private static final Logger log = LoggerFactory.getLogger(LoggingObserver.class);
    private final TicketService ticketService;

    @Autowired
    public LoggingObserver(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public void onTicketPurchased(Ticket ticket) {
        log.info("TICKET PURCHASED | Customer: {} | Festival: {} | Price: {}",
                ticket.getCustomer().getName(),
                ticket.getFestival().getName(),
                ticketService.calculatePrice(ticket));
    }
}