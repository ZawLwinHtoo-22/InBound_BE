package com.inbound.inbound_be.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PremiumRequest {
    private Boolean isChild;
    private Integer co_plan;
    private LocalDate ch_dob;
    private LocalDate i_dob;
}
