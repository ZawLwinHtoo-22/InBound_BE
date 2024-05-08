package com.inbound.inbound_be.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CountryRequest {

    private String country_name;
    private String country_code;
}
