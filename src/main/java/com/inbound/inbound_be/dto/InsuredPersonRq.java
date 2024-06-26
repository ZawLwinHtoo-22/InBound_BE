package com.inbound.inbound_be.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class InsuredPersonRq {

    private String i_name;
    private LocalDate i_dob;
    private String i_gender;
    private String i_phone;
    private String i_email;
    private String i_person_address;
    private String r_person_address;
    private String passportNumber;
    private LocalDate i_passport_issue_date;
    private Boolean isChild;
    private String passportCountry;
    private UUID b_fk;
    private UUID r_country;


}
