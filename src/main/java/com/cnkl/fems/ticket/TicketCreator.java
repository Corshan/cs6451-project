package com.cnkl.fems.ticket;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.festival.Festival;

public abstract class TicketCreator {
    public abstract Ticket createTicket(Festival festival, Customer customer,
                                        TicketTypes type);
}