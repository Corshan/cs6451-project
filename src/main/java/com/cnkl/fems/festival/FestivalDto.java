package com.cnkl.fems.festival;

import java.util.List;
import java.util.Objects;

public class FestivalDto {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getTickets() {
        return tickets;
    }

    public void setTickets(List<Long> tickets) {
        this.tickets = tickets;
    }

    private Long id;
    private String name;
    private List<Long> tickets;

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(((FestivalDto) obj).id, this.id);
    }
}
