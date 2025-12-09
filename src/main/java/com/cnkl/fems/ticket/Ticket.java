package com.cnkl.fems.ticket;
import com.cnkl.fems.festival.Festival;
import com.cnkl.fems.customer.Customer;

import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "festival_id")
    private Festival festival;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private TicketTypes ticketType;

    private boolean vip;

    public Ticket() {}

    public Ticket (Festival festival, Customer customer, TicketTypes ticketType) {
        this.festival = festival;
        this.customer = customer;
        this.ticketType = ticketType;
    }

    public Long getId () {
        return id;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TicketTypes getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketTypes ticketType){
        this.ticketType = ticketType;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

}