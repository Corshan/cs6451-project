package com.cnkl.fems.ticket;

public class SeniorTicket implements TicketType{
    private float cost;
    private static final float DISCOUNT = 0.10f;

    public SeniorTicket(float cost) {
        this.cost = cost;
    }

    @Override
    public float getTicketPrice() {
        return cost * (1 - DISCOUNT);
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
