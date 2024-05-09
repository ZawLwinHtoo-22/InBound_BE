package com.inbound.inbound_be.controller;

import com.inbound.inbound_be.dto.PremiumRequest;
import com.inbound.inbound_be.dto.PremiumResponse;
import com.inbound.inbound_be.service.PremiumRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/premium")
public class PremiumRateController {
    @Autowired
    private PremiumRateService service;

    @GetMapping
    public ResponseEntity<PremiumResponse> getPremium(@RequestBody PremiumRequest request){
        PremiumResponse response=service.getByAge(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
