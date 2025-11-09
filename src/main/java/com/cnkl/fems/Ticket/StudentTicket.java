package com.cnkl.fems.Ticket;

public class StudentTicket implements TicketType{
    private float cost;
    private static final float DISCOUNT = 0.15f;

    public StudentTicket(float cost) {
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
