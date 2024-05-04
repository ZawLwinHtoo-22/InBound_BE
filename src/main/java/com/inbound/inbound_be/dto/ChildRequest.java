package com.inbound.inbound_be.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter

public class ChildRequest {

    private String ch_name;
    private LocalDate ch_dob;
    private String ch_gender;
    private String ch_gu_Name;
    private String ch_rs;
    private UUID i_id;
}
