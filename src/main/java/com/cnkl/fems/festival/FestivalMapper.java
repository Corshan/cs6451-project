package com.cnkl.fems.festival;

import com.cnkl.fems.ticket.Ticket;

public class FestivalMapper {

    public static FestivalDto toDto(Festival festival){
        FestivalDto dto = new FestivalDto();
        dto.setId(festival.getId());
        dto.setName(festival.getName());
        dto.setTickets(festival.getTickets().stream().map(Ticket::getId).toList());
        return dto;
    }
}
