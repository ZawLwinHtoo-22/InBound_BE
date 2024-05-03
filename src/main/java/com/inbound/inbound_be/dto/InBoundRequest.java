package com.inbound.inbound_be.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter

public class InBoundRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

}
