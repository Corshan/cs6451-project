
package com.cnkl.fems.festival;

import com.cnkl.fems.festival.stall.Stall;
import com.cnkl.fems.ticket.Ticket;

import com.cnkl.fems.festivalOrganiser.FestivalOrganiser;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private float baseTicketCost;

    @OneToMany(mappedBy = "festival")
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "festival")
    private List<Stall> stalls = new ArrayList<>();

    @ManyToOne
    private FestivalOrganiser festivalOrganiser;

    public Festival(String name, float baseTicketCost) {
        this.name = name;
        this.baseTicketCost = baseTicketCost;
    }

    public Festival() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBaseTicketCost() {return baseTicketCost;}

    public void setBaseTicketCost(float baseTicketCost) {this.baseTicketCost = baseTicketCost;}

    public List<Ticket> getTickets() { return tickets; }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        ticket.setFestival(this);
    }

    public List<Stall> getStalls() {
        return stalls;
    }

    public void addStall(Stall stall) {
        stalls.add(stall);
        stall.setFestival(this);
    }
}
