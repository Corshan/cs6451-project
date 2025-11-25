package com.cnkl.fems.festival;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.customer.CustomerRepository;
import com.cnkl.fems.ticket.Ticket;
import com.cnkl.fems.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FestivalService {

    private final FestivalRepository festivalRepository;
    private final TicketRepository ticketRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public FestivalService(FestivalRepository festivalRepository, TicketRepository ticketRepository, CustomerRepository customerRepository) {
        this.festivalRepository = festivalRepository;
        this.ticketRepository = ticketRepository;
        this.customerRepository = customerRepository;
    }

    public List<Festival> getAllFestivals() {
        return festivalRepository.findAll();
    }

    public Optional<Festival> getFestivalById(Long id) {
        return festivalRepository.findById(id);
    }

    public Festival createFestival(Festival festival) {
        return festivalRepository.save(festival);
    }

    public void deleteFestivalById(Long id) {
        festivalRepository.deleteById(id);
    }

    public Ticket purchaseTicket(long id, long customerId) {
        Optional<Festival> optionalFestival = festivalRepository.findById(id);
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalFestival.isPresent() && optionalCustomer.isPresent()) {
            Festival festival = optionalFestival.get();
            Customer customer = optionalCustomer.get();

            Ticket ticket = festival.purchaseTicket(customer);

            if (ticket != null) {
                return ticketRepository.save(ticket);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
