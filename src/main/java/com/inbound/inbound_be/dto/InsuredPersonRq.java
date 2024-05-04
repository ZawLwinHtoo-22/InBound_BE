package com.inbound.inbound_be.dto;

import com.inbound.inbound_be.entity.InsuredPerson;
import com.inbound.inbound_be.repo.InsuredPersonRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
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
    private UUID b_fk;
    private Boolean isChild = false;

    public static InsuredPerson of(InsuredPersonRq rq){
        return new InsuredPerson()
                .builder()
                .i_name(rq.getI_name())
                .i_dob(rq.getI_dob())
                .i_gender(rq.getI_gender())
                .i_phone(rq.getI_phone())
                .i_email(rq.getI_email())
                .i_person_address(rq.getI_person_address())
                .r_person_address(rq.getR_person_address())
                .r_country(rq.getR_country())
                .i_passport_name(rq.getI_passport_name())
                .i_passport_issue_date(rq.getI_passport_issue_date())
                .build();
    }
}
