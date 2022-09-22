package com.bilgeli.accountservice.api;

import com.bilgeli.accountservice.entity.Account;
import com.bilgeli.accountservice.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* di bu nesnenin spring contexti içerisinde bir instancenın yaratılması için spring anatasyonuna sahip olması lazım
 * sadece instancenın oluşup ramde bir nesnesinin oluşup bir şekilde hizmet vermesi anlamıan geliyor
 * oluştuktan sonra dış dunyaya açılması lazım, web servis apisi olması lazım
 * service: instance yaratır bu instance ramde yasar kim bunu kullanırsa jvm içerisinde ona hizmet eder
 * RestController: dış dunyaya açılan bir katman olacağını bir instance yaratacağını, onun aracılığyla da  http metodlarına hizmet eden bir takım metodlar yayınlayacağını soyler
 */

@RestController //dıs dunyaya acılsın
@RequestMapping("account") // bu adreste yayınlansın
public class AccountApi {
    private final AccountService accountService ;

    public AccountApi(AccountService accountService) {
        this.accountService = accountService;
    }

    // ResponseEntity : özel bi geri dönüş nesnesi oluşturuyor. ( status, responseTime, ..)
    @GetMapping("/{id}") // sunucudaki nesneyi istemek icin
    public ResponseEntity<Account> get(@PathVariable("id") String id){
        return ResponseEntity.ok(accountService.get(id));
    }

    @PostMapping // sunucuda kayıt olusturmak icin
    public ResponseEntity<Account> save(@RequestBody Account account){
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping
    public ResponseEntity<Account> update(@PathVariable("id") String id, @RequestBody Account account){
        return ResponseEntity.ok(accountService.update(id, account));
    }

    @DeleteMapping
    public void delete(String id){
        accountService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<Account>> get(){
        return ResponseEntity.ok(accountService.findAll());
    }
    /*public ResponseEntity<Account> pagination(){

    }*/
}
