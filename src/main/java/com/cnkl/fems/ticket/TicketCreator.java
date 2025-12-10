package com.cnkl.fems.ticket;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.festival.Festival;

public interface TicketCreator {


    Ticket saveNewTicket(Festival festival, Customer customer, TicketTypes type);
}