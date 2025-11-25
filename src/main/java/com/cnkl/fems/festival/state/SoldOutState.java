package com.cnkl.fems.festival.state;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.festival.Festival;
import com.cnkl.fems.ticket.Ticket;

public class SoldOutState extends FestivalState{

    @Override
    public Ticket purchaseTicket(Festival festival, Customer customer) {
        Ticket ticket = new Ticket();
        ticket.setFestival(festival);
        ticket.setCustomer(customer);

        if(festival.getTotalTicketsSold() <= festival.getTotalTickets()){
            festival.getTickets().add(ticket);
            festival.setFestivalState(new OpenState());
            return ticket;
        }else {
            return null;
        }
    }

    @Override
    public String name() {
        return "Sold Out";
    }
}
