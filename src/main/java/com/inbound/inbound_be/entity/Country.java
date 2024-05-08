package com.inbound.inbound_be.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Country {

//    co - country

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID country_id;
    private String country_name;
    private String country_code;


}
