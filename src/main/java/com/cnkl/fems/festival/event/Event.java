package com.cnkl.fems.festival.event;

import com.cnkl.fems.festival.venue.Venue;
import jakarta.persistence.*;
import java.math.BigDecimal;
import com.cnkl.fems.festival.Festival;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal cost;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    private Venue location;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "festival_id")
    private Festival festival;


    private String status = "Draft";


    public Event() {}


    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public BigDecimal getCost()
    {
        return cost;
    }
    public void setCost(BigDecimal cost)
    {
        this.cost = cost;
    }
    public Venue getLocation()
    {
        return location;
    }
    public void setLocation(Venue location)
    {
        this.location = location;
    }
    public Festival getFestival()
            {
                return festival;
            }
    public void setFestival(Festival festival)
    {
        this.festival = festival;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
}