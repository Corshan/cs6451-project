package com.cnkl.fems.ticket;

public class BaseTicket implements TicketType{
    private float cost;

    public BaseTicket(float cost) {
        this.cost = cost;
    }

    @Override
    public float getTicketPrice() {
        return cost;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
