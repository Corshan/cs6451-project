package com.cnkl.fems.customer;
import com.cnkl.fems.ticket.Ticket;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dob;
    private String email;
    private String phone;
    private List<Ticket> tickets;

    //Constructor
    public Customers(Long id, String name, Date dob, String email, String phone) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.tickets = new ArrayList<>();
    }

    //Getter for ID
    public Long getId() {
        return id;
    }

    //Setter for ID
    public void setID(Long id) {
        this.id = id;
    }

    //Getter for name
    public String getName() {
        return name;
    }

    //Setter for name
    public void setName(String name) {
        this.name = name;
    }

    //Getter for DOB
    public Date getDob() {
        return dob;
    }

    //Setter for DOB
    public void setDob(Date dob) {
        this.dob = dob;
    }

    //Getter for email
    public String getEmail() {
        return email;
    }

    //Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    //Getter for phone
    public String getPhone() {
        return phone;
    }

    //Setter for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    //Getter for tickets
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void purchaseTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}
