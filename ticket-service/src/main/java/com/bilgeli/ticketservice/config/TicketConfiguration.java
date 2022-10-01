package com.bilgeli.ticketservice.config;

import com.bilgeli.client.AccountServiceClient;
import com.bilgeli.client.contract.AccountDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Configuration
@EnableJpaRepositories("com.bilgeli")
@ComponentScan("com.bilgeli")
public class TicketConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
