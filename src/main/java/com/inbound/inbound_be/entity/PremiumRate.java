package com.inbound.inbound_be.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
public class PremiumRate {

//    c = currency
//    gu = guardiance
//    i = insured
//    pre = premium

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID pre_id;
    private Integer policyDays;
    private Integer fromAge;
    private Integer toAge;
    private Double pre_rate;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private Integer version;
}
