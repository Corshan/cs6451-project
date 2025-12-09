package com.cnkl.fems.festival.state;

import com.cnkl.fems.customer.Customer;
import com.cnkl.fems.festival.Festival;
import com.cnkl.fems.ticket.Ticket;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "state")
public abstract class FestivalState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public abstract Ticket purchaseTicket(Festival festival, Customer customer);

    public abstract String name();
}
