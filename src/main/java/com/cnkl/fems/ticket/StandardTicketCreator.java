package com.cnkl.fems.ticket;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.festival.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("standardTicketService")
public class StandardTicketCreator extends TicketFactoryService {

    @Autowired
    public StandardTicketCreator(TicketRepository ticketRepository, TicketPriceFactory ticketPriceFactory)
    {
        super(ticketRepository, ticketPriceFactory);
    }

    @Override
    protected Ticket createTicketProduct(Festival festival, Customer customer, TicketTypes type)
    {
        return new StandardTicket(festival, customer, type);
    }
}