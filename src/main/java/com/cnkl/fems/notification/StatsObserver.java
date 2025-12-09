package com.cnkl.fems.notification;

import com.cnkl.fems.ticket.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatsObserver implements TicketPurchaseObserver {
    private static int totalTicketsSold = 0;
    private static double totalRevenue = 0.0;
    private final TicketService ticketService;

    @Autowired
    public StatsObserver(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public void onTicketPurchased(Ticket ticket) {
        totalTicketsSold++;
        totalRevenue += ticketService.calculatePrice(ticket);

        System.out.printf("STATS UPDATE: Total Tickets Sold = %d | Revenue = $%.2f%n",
                totalTicketsSold, totalRevenue);
    }
}