package com.bilgeli.ticketservice.service.impl;

import com.bilgeli.client.AccountServiceClient;
import com.bilgeli.client.contract.AccountDto;
import com.bilgeli.ticketservice.dto.TicketDto;
import com.bilgeli.ticketservice.model.PriorityType;
import com.bilgeli.ticketservice.model.Ticket;
import com.bilgeli.ticketservice.model.TicketStatus;
import com.bilgeli.ticketservice.repository.TicketRepository;
import com.bilgeli.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    //private final TicketElasticRepository ticketElasticRepository;
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;
    private final AccountServiceClient accountServiceClient;

    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto) {
        // ticket entity
        Ticket ticket = new Ticket();

        //TODO account API dan dogrula
        // ticket.setAssignee();
        ResponseEntity<AccountDto> accountDtoResponseEntity= accountServiceClient.get(ticketDto.getAssignee());

        if (ticketDto.getDescription() == null)
            new IllegalArgumentException("Description bos olamazz");

        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setAssignee(accountDtoResponseEntity.getBody().getId());
        // mysql kaydet
        ticket = ticketRepository.save(ticket);

        // ticket model nesnesi yarat
        /*TicketModel ticketModel = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .assignee(accountDtoResponseEntity.getBody().getNameSurname())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate()).build();*/

        // elastic kaydet
        //ticketElasticRepository.save(ticketModel);

        // olusan nesneyi dondur
        ticketDto.setId(ticket.getId());
        return ticketDto;
    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}
