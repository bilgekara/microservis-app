package com.bilgeli.ticketservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    private String id;
    private String description;
    private String notes;
    private String assignee;
    private Date ticketDate;
    private String  priorityType;
    private String ticketStatus;
}
