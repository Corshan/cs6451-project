package com.cnkl.fems.ticket;

public class TicketMapper {
    public static TicketDto toDto(Ticket ticket){
        TicketDto dto = new TicketDto();
        dto.setId(ticket.getId());
        dto.setFestival_id(ticket.getFestival().getId());
        dto.setCustomer_id(ticket.getCustomer().getId());
        return dto;
    }
}
