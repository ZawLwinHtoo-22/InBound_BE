package com.inbound.inbound_be.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Child {

//    ch = child

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ch_id;
    private String ch_name;
    private LocalDate ch_dob;
    private String ch_gender;

}
