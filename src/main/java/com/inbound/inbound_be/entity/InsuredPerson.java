package com.inbound.inbound_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsuredPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

//    i = insured person
//    r = resident person
//    ch = child
//    b = beneficiary

    private UUID i_person_id;
    private String i_name;
    private LocalDate i_dob;
    private String i_gender;
    private String i_phone;
    private String i_email;
    private String i_person_address;
    private String r_person_address;
    private LocalDate i_passport_issue_date;
    private String passportNumber;
    private Boolean isChild;
    private String passportCountry;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private Integer version;

//    private UUID ch_fk;
//    private UUID b_fk;

    @OneToOne
    @JoinColumn(name = "b_fk")
    private Beneficiary beneficiary;

    @ManyToOne
    @JoinColumn(name = "r_country")
    private Country country;

}
