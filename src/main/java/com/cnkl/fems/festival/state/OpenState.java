package com.cnkl.fems.festival.state;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.festival.Festival;
import com.cnkl.fems.ticket.Ticket;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("open")
public class OpenState extends FestivalState{
    @Override
    public Ticket purchaseTicket(Festival festival, Customer customer) {
        Ticket ticket = new Ticket();
        ticket.setFestival(festival);
        ticket.setCustomer(customer);

        if(festival.getTotalTicketsSold() <= festival.getTotalTickets()){
            festival.getTickets().add(ticket);
            return ticket;
        }else {
            festival.setFestivalState(new SoldOutState());
            return null;
         }

    }

    @Override
    public String name() {
        return "Open";
    }
}
