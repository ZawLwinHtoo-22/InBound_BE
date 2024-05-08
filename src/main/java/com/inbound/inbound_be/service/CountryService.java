package com.inbound.inbound_be.service;

import com.inbound.inbound_be.dto.CountryRequest;
import com.inbound.inbound_be.entity.Country;

import java.util.List;
import java.util.UUID;

public interface CountryService {

    List<Country> addCountry(List<CountryRequest> request);
    List<Country> showAll();
    Country showWithId(UUID co_id);
    void deleteCountry(UUID co_id);
}
