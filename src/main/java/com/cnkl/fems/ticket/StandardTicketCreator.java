package com.cnkl.fems.ticket;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.festival.Festival;

public class StandardTicketCreator extends TicketCreator {

    @Override
    public Ticket createTicket (Festival festival, Customer customer,
                                TicketTypes type) {
        return new StandardTicket (festival, customer, type);
    }
}