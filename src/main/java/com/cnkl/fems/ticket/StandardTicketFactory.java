package com.cnkl.fems.ticket;
import com.cnkl.fems.festival.Festival;
import com.cnkl.fems.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class StandardTicketFactory implements TicketAbstractFactory {
    @Override
    public Ticket createTicket(TicketTypes type, Festival festival, Customer customer) {
        return new StandardTicket(festival, customer, type);
    }
}