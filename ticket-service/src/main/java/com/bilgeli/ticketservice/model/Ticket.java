package com.bilgeli.ticketservice.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntityModel{
    @Getter
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private String id;

    @Getter
    @Setter
    @Column(name = "description", length = 600)
    private String description;
    @Getter
    @Setter
    @Column(name = "notes", length = 4000)
    private String notes;
    @Getter
    @Setter
    @Column(name = "assignee", length = 50)
    private String assignee;
    @Getter
    @Setter
    @Column(name = "ticket_date")
    private Date ticketDate;
    @Getter
    @Setter
    @Column(name = "priority_type")
    @Enumerated(EnumType.ORDINAL)
    private PriorityType priorityType;
    @Getter
    @Setter
    @Column(name = "ticket_status")
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;

}
