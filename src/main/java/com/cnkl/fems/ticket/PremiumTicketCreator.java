package com.cnkl.fems.ticket;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.festival.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("premiumTicketService")
public class PremiumTicketCreator extends TicketFactoryService {

    @Autowired
    public PremiumTicketCreator(TicketRepository ticketRepository, TicketPriceFactory ticketPriceFactory)
    {
        super(ticketRepository, ticketPriceFactory);
    }

    @Override
    protected Ticket createTicketProduct(Festival festival, Customer customer, TicketTypes type)
    {
        return new PremiumTicket(festival, customer, type);
    }
}