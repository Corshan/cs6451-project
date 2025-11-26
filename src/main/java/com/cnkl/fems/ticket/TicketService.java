package com.cnkl.fems.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.cnkl.fems.festival.Festival;
import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.ticket.TicketAbstractFactory;
import com.cnkl.fems.ticket.StandardTicketFactory;
@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketAbstractFactory ticketFactory;

    @Autowired
    public TicketService(TicketRepository ticketRepository, StandardTicketFactory standardTicketFactory) {
        this.ticketRepository = ticketRepository;
        this.ticketFactory = standardTicketFactory;

    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket createTicket(TicketTypes type, Festival festival, Customer customer) {

        Ticket newTicket = ticketFactory.createTicket(type, festival, customer);

        return ticketRepository.save(newTicket);
    }

    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);
    }
}
