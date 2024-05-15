package com.inbound.inbound_be.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class CountryRequest {

    private String country_name;
    private String country_code;
}
