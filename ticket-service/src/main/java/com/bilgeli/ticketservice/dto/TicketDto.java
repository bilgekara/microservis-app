package com.bilgeli.ticketservice.dto;

import com.bilgeli.ticketservice.model.PriorityType;
import com.bilgeli.ticketservice.model.TicketStatus;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
