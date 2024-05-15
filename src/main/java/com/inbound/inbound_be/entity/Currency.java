package com.inbound.inbound_be.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Currency {

//    cu - currency

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID cu_id;
    private String currency;
    private String description;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private Integer version;
}
