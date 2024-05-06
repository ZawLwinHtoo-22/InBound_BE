package com.inbound.inbound_be.dto;

import com.inbound.inbound_be.entity.InsuredPerson;
import com.inbound.inbound_be.repo.InsuredPersonRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private String r_country;
    private String i_passport_name;
    private LocalDate i_passport_issue_date;
    private Boolean isChild = false;
    private UUID b_fk;


}
