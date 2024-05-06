package com.inbound.inbound_be.service.impl;

import com.inbound.inbound_be.dto.CountryRequest;
import com.inbound.inbound_be.entity.Country;
import com.inbound.inbound_be.repo.CountryRepo;
import com.inbound.inbound_be.service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepo repo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public List<Country> addCountry(List<CountryRequest> requests) {
        List<Country> countries = new ArrayList<>();
        for (CountryRequest request : requests) {
            Country country = mapper.map(request, Country.class);
            countries.add(repo.save(country));
        }
        return countries;
    }

    @Override
    public List<Country> showAll() {
        return repo.findAll();
    }

    @Override
    public Country showWithId(UUID co_id) {
        Country country = repo.findById(co_id)
                .orElseThrow( () -> new IllegalArgumentException("No Country"));
        return country;
    }

    @Override
    public void deleteCountry(UUID co_id) {
        if(repo.existsById(co_id)){
            repo.deleteById(co_id);
        }
    }
}
