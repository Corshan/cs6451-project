package com.cnkl.fems.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.cnkl.fems.festival.Festival;
import com.cnkl.fems.customer.Customer;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketPriceFactory ticketPriceFactory;


    @Autowired
    public TicketService(TicketRepository ticketRepository, TicketPriceFactory ticketPriceFactory) {
        this.ticketRepository = ticketRepository;
        this.ticketPriceFactory = ticketPriceFactory;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket createTicket( Festival festival, Customer customer ,TicketTypes type,TicketCreator creator) {

        Ticket ticket =  creator.createTicket(festival,customer,type);

        return ticketRepository.save(ticket);
    }

    public float calculatePrice(Ticket ticket) {
        TicketPriceComponent component = ticketPriceFactory.create(ticket);
        return component.getTotalPrice();
    }

    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);
    }
}
