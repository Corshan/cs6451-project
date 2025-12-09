package com.cnkl.fems.ticket;

public class TicketPriceFactory {

    public TicketPriceComponent create(Ticket ticket) {
        TicketPriceComponent component = new BaseTicketComponent(ticket);

        if (ticket.isVip()) {
            component = new VIPDecorator(component);
        }

        return component;
    }
}
