package com.cnkl.fems.ticket;

public abstract class TicketDecorator implements TicketPriceComponent{
    protected final TicketPriceComponent component;

    public TicketDecorator(TicketPriceComponent component) {
        this.component = component;
    }

    @Override
    public float getTotalPrice() {
        return component.getTotalPrice();
    }
}
