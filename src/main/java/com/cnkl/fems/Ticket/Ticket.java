package com.cnkl.fems.Ticket;

public class Ticket {
    private int id;
    private Festival festival;
    private int customerId;
    private TicketType ticketType;

    public Ticket (int id, Festival festival, int customerId, TicketType ticketType) {
        this.id = id;
        this.festival = festival;
        this.customerId = customerId;
        this.ticketType = ticketType;
    }

    public int getId () {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType){
        this.ticketType = ticketType;
    }

    public float getTotalPrice() {
        return ticketType.getTicketPrice();
    }
}
