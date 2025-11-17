package com.cnkl.fems.Ticket;
import com.cnkl.fems.festival.Festival;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Festival festival;
    private Long customerId;
    private TicketType ticketType;

    public Ticket (Long id, Festival festival, Long customerId, TicketType ticketType) {
        this.id = id;
        this.festival = festival;
        this.customerId = customerId;
        this.ticketType = ticketType;
    }

    public Long getId () {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
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
