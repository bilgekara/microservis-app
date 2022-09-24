package com.bilgeli.accountservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration -> sspring ayağa kalkarken bunu initialize etsin (modelmapper diye bir instanace donen)
@Configuration
public class CustomBeanFactory {
    @Bean
    public ModelMapper getModelMapper(){
        // projemin singleton bir tane model mapper instanceını oluşturcam
        return new ModelMapper();
    }
}
