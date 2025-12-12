
package com.cnkl.fems.customer;
import com.cnkl.fems.ticket.Ticket;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dob;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "customer")
    private List<Ticket> tickets = new ArrayList<>();

    public Customer() {}

    //Constructor
    public Customer(String name, Date dob, String email, String phone) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }

    public Customer(long id, String name, Date dob, String email, String phone) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }

    //Getter for ID
    public Long getId() {
        return id;
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
        ticket.setCustomer(this);
    }
}
