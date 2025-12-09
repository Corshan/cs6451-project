package com.cnkl.fems.festival;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.customer.CustomerRepository;
import com.cnkl.fems.ticket.Ticket;
import com.cnkl.fems.ticket.TicketDto;
import com.cnkl.fems.ticket.TicketMapper;
import com.cnkl.fems.ticket.TicketRepository;
import org.hibernate.annotations.NotFound;
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

    public List<FestivalDto> getAllFestivals() {
        return festivalRepository.findAll().stream().map(FestivalMapper::toDto).toList();
    }

    public Optional<Festival> getFestivalById(Long id) {
        return festivalRepository.findById(id);
    }

    public Festival createFestival(Festival festival) {
        return festivalRepository.save(festival);
    }

    public void openFestival(long id){
        Optional<Festival> optional = festivalRepository.findById(id);

        if(optional.isEmpty()) throw new RuntimeException("Festival doesn't exist");

        Festival festival = optional.get();
        festival.setStateOpen();
        festivalRepository.save(festival);
    }

    public void closeFestival(long id){
        Optional<Festival> optional = festivalRepository.findById(id);

        if(optional.isEmpty()) throw new RuntimeException("Festival doesn't exist");

        Festival festival = optional.get();
        festival.setStateClosed();
        festivalRepository.save(festival);
    }

    public void deleteFestivalById(Long id) {
        festivalRepository.deleteById(id);
    }

    public TicketDto purchaseTicket(long id, long customerId) {
        Optional<Festival> optionalFestival = festivalRepository.findById(id);
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalFestival.isEmpty()) throw new RuntimeException("Festival doesn't exist");
        if (optionalCustomer.isEmpty()) throw new RuntimeException("Customer doesn't exist");

        Festival festival = optionalFestival.get();
        Customer customer = optionalCustomer.get();

        Ticket ticket = festival.purchaseTicket(customer);

        if (ticket == null) throw new RuntimeException(String.format("Current State: %s", festival.getCurrentState()));

        return TicketMapper.toDto(ticketRepository.save(ticket));
    }
}
