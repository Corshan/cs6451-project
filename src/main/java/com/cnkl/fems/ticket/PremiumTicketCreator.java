package com.cnkl.fems.ticket;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.festival.Festival;

public class PremiumTicketCreator extends TicketCreator {

    @Override
    public Ticket createTicket (Festival festival, Customer customer,
                                TicketTypes type) {
        return new PremiumTicket (festival, customer, type);
    }
}
