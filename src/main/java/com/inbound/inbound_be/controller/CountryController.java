package com.inbound.inbound_be.controller;

import com.inbound.inbound_be.dto.CountryRequest;
import com.inbound.inbound_be.entity.Country;
import com.inbound.inbound_be.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService service;

    @PostMapping
    public ResponseEntity<List<Country>> addCountries(@RequestBody List<CountryRequest> requests){
        List<Country> addedCountries = service.addCountry(requests);
        return new ResponseEntity<>(addedCountries, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Country>> showAll(){
        List<Country> show = service.showAll();
        return new ResponseEntity<>(show, HttpStatus.OK);
    }

    @GetMapping("/{co_id}")
    public ResponseEntity<Country> showWithId(@PathVariable UUID co_id){
        Country country = service.showWithId(co_id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @DeleteMapping("/{co_id}")
    public ResponseEntity<String > deleteCountry(@PathVariable UUID co_id){
        service.deleteCountry(co_id);
        return new ResponseEntity<>("Successfully Delete", HttpStatus.OK);
    }
}
