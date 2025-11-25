package com.cnkl.fems.festival.state;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.festival.Festival;
import com.cnkl.fems.ticket.Ticket;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("closed")
public class ClosedState extends FestivalState {

    @Override
    public Ticket purchaseTicket(Festival festival, Customer customer) {
        return null;
    }

    @Override
    public String name() {
        return "Closed";
    }
}
