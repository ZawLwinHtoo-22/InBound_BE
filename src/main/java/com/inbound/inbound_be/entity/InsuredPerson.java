package com.inbound.inbound_be.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Getter
@Setter
public class InsuredPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

//    i = insured person
//    r = resident person
//    ch = child
//    b = beneficiary

    private UUID i_person_id;
    private String i_name;
    private LocalDateTime i_dob;
    private String i_gender;
    private String i_phone;
    private String i_email;
    private String i_person_address;
    private String r_person_address;
    private String r_country;
    private String i_passport_name;
    private LocalDate i_passport_issue_date;

    private UUID ch_fk;
    private UUID b_fk;



}
