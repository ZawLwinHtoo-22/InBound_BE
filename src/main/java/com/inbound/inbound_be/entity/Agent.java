package com.inbound.inbound_be.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID a_id;
    private String a_name;
    private Integer licenseNo;
    private Integer password;
    public static Agent of(Agent request){
        Agent agent = new Agent();
        agent.a_name = request.getA_name();
        agent.licenseNo = request.getLicenseNo();
        agent.password = request.getPassword();


        return agent;
    }

}
