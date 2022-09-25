package com.bilgeli.ticketservice.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass // jpa de bir nesneyi kalıtım yoluyla diğer nesnelere kazandırmak için
public abstract class BaseEntityModel implements Serializable {
    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
