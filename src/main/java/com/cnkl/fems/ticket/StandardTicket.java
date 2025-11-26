package com.cnkl.fems.ticket;
import com.cnkl.fems.festival.Festival;
import com.cnkl.fems.customer.Customer;
import jakarta.persistence.Entity;

@Entity
public class StandardTicket extends Ticket {
    public StandardTicket() { super(); }
    public StandardTicket(Festival festival, Customer customer, TicketTypes ticketType) {
        super(festival, customer, ticketType);
        this.setVip(false);
    }
}