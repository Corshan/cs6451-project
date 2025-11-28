package com.cnkl.fems.ticket;

public class VIPDecorator extends TicketDecorator{
    private static final float VIP_SURCHARGE = 50.0f;

    public VIPDecorator(TicketPriceComponent component) {
        super(component);
    }

    @Override
    public float getTotalPrice() {
        return super.getTotalPrice() + VIP_SURCHARGE;
    }
}
