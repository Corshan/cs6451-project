package com.cnkl.fems.notification;

import com.cnkl.fems.ticket.Ticket;

public interface TicketPurchaseObserver {
    void onTicketPurchased(Ticket ticket);
}