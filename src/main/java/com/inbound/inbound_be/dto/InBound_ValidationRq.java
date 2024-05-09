package com.inbound.inbound_be.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InBound_ValidationRq {

    private String passportNumber;
    private String passportCountry;
}
