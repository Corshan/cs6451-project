package com.cnkl.fems.venue;

import jakarta.persistence.*;

@Entity
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String venueType;


    public Venue() {}


    public Long getId()
    { return id;
    }
    public void setId(Long id) {
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
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getVenueType()
    {
        return venueType;
    }
    public void setVenueType(String venueType)
    {
        this.venueType = venueType;
    }
}
