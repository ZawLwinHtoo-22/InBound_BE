package com.inbound.inbound_be.entity;

import com.inbound.inbound_be.dto.BeneficiaryRq;
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

public class Beneficiary {

//    b = beneficiary

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID b_id;
    private String b_name;
    private LocalDate b_date;
    private String b_nrc;
    private String b_rs;
    private String b_ph;
    private String b_email;
    private String b_address;
    private String b_country;


}
