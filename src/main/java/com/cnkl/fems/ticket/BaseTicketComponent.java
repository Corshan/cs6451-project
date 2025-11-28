package com.cnkl.fems.ticket;

public class BaseTicketComponent implements TicketPriceComponent{
    private final Ticket ticket;

    public BaseTicketComponent(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public float getTotalPrice() {
        return ticket.getTicketType().getTicketPrice(ticket.getFestival().getBaseTicketCost());
    }
}
