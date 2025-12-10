package com.cnkl.fems.ticket;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.festival.Festival;

public abstract class TicketFactoryService implements TicketCreator {

    protected final TicketRepository ticketRepository;
    protected final TicketPriceFactory ticketPriceFactory;

    public TicketFactoryService(TicketRepository ticketRepository, TicketPriceFactory ticketPriceFactory) {
        this.ticketRepository = ticketRepository;
        this.ticketPriceFactory = ticketPriceFactory;
    }


    @Override
    public final Ticket saveNewTicket(Festival festival, Customer customer, TicketTypes type) {


        Ticket ticket = createTicketProduct(festival, customer, type);


        return ticketRepository.save(ticket);
    }


    protected abstract Ticket createTicketProduct(Festival festival, Customer customer, TicketTypes type);
}
