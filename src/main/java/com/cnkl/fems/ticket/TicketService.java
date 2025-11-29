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


    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;

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

    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);
    }
}
