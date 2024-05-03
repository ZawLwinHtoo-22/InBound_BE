package com.inbound.inbound_be.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID agent_id;
    private String a_name;
    private Integer a_password;
    private Integer a_licenseNo;

}
