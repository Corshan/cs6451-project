package com.cnkl.fems.ticket;
import com.cnkl.fems.festival.Festival;
import com.cnkl.fems.customer.Customer;
import jakarta.persistence.Entity;

@Entity
public class PremiumTicket extends Ticket {
    public PremiumTicket() { super(); }
    public PremiumTicket(Festival festival, Customer customer, TicketTypes ticketType) {
        super(festival, customer, ticketType);
        this.setVip(true);
    }
}