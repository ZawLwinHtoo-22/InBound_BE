package com.inbound.inbound_be.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Inbound_ProposalRequest {
    private String j_from;
    private String j_to;
    private LocalDate e_ar_date;
    private Integer co_plan;
    private String i_name;
    private LocalDate i_dob;
    private String i_gender;
    private String i_phone;
    private String i_email;
    private String i_person_address;
    private String r_person_address;
    private UUID r_country_i;
    private String passportNumber;
    private LocalDate i_passport_issue_date;
    private Boolean isChild;
    private Integer licenseNo;
    private String ch_name;
    private LocalDate ch_dob;
    private String ch_gender;
    private String ch_gu_Name;
    private String ch_rs;
    private String b_name;
    private LocalDate b_date;
    private String b_nrc;
    private String b_rs;
    private String b_ph;
    private String b_email;
    private String b_address;
    private UUID r_country_b;
    private Double pre_rate;
    private String passportCountry;
    private Integer age;
}
