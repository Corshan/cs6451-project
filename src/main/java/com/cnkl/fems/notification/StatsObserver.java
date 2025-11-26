package com.cnkl.fems.notification;

import com.cnkl.fems.ticket.Ticket;
import org.springframework.stereotype.Component;

@Component
public class StatsObserver implements TicketPurchaseObserver {
    private static int totalTicketsSold = 0;
    private static double totalRevenue = 0.0;

    @Override
    public void onTicketPurchased(Ticket ticket) {
        totalTicketsSold++;
        totalRevenue += ticket.getTotalPrice();

        System.out.printf("STATS UPDATE: Total Tickets Sold = %d | Revenue = $%.2f%n",
                totalTicketsSold, totalRevenue);
    }
}