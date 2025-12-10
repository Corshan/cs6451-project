
package com.cnkl.fems.festival;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.festival.stall.Stall;
import com.cnkl.fems.festival.state.ClosedState;
import com.cnkl.fems.festival.state.FestivalState;
import com.cnkl.fems.festival.state.OpenState;
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
    private int totalTickets;

    @OneToOne(cascade=CascadeType.ALL)
    private FestivalState state = new ClosedState();

    @OneToMany(mappedBy = "festival", cascade=CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "festival", cascade=CascadeType.ALL)
    private List<Stall> stalls = new ArrayList<>();

    @ManyToOne(cascade=CascadeType.ALL)
    private FestivalOrganiser festivalOrganiser;

    public Festival(String name, float baseTicketCost, int totalTickets) {
        this.name = name;
        this.baseTicketCost = baseTicketCost;
        this.totalTickets = totalTickets;
    }

    public Festival(long id, String name, float baseTicketCost, int totalTickets){
        this.id = id;
        this.name = name;
        this.baseTicketCost = baseTicketCost;
        this.totalTickets = totalTickets;
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

    public Ticket purchaseTicket(Customer customer) {
        return state.purchaseTicket(this, customer);
    }

    public int getTotalTicketsSold(){
        return tickets.size();
    }

    public List<Stall> getStalls() {
        return stalls;
    }

    public void addStall(Stall stall) {
        stalls.add(stall);
        stall.setFestival(this);
    }

    public FestivalState getFestivalState() {
        return state;
    }

    public void setFestivalState(FestivalState state) {
        this.state = state;
    }

    public String getCurrentState() {
        return state.name();
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public void setStateOpen(){
        this.state = new OpenState();
    }

    public void setStateClosed(){
        this.state = new ClosedState();
    }
}
