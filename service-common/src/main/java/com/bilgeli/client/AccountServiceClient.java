package com.bilgeli.client;

import com.bilgeli.client.contract.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// account servisle konusmam gereken api metodlarının bir nevi tanımları  yer alıcak
@FeignClient("account-service")
public interface AccountServiceClient {
    @RequestMapping("/account/{id}") // sunucudaki nesneyi istemek icin
    ResponseEntity<AccountDto> get(@PathVariable("id") String id);
}
