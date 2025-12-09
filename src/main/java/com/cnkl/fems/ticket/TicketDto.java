package com.cnkl.fems.ticket;

public class TicketDto {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFestival_id() {
        return festival_id;
    }

    public void setFestival_id(long festival_id) {
        this.festival_id = festival_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    private long id;
    private long festival_id;
    private long customer_id;
}
