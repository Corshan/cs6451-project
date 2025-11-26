package com.cnkl.fems.ticket;
import com.cnkl.fems.festival.Festival;
import com.cnkl.fems.customer.Customer;

public interface TicketAbstractFactory {
    Ticket createTicket(TicketTypes type, Festival festival, Customer customer);
}