package com.inbound.inbound_be.controller;

import com.inbound.inbound_be.dto.BeneficiaryRq;
import com.inbound.inbound_be.entity.Beneficiary;
import com.inbound.inbound_be.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/beneficiary")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService service;

    @PostMapping
    public ResponseEntity<Beneficiary> addBeneficiary(@RequestBody BeneficiaryRq rq){
        Beneficiary beneficiary = service.addBeneficiary(rq);
        return new ResponseEntity<>(beneficiary, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Beneficiary>> showAll(){
        List<Beneficiary> beneficiaries = service.showAll();
        return new ResponseEntity<>(beneficiaries, HttpStatus.OK);
    }

    @GetMapping("/{b_id}")
    public ResponseEntity<Beneficiary> showWithId(@PathVariable UUID b_id){
        Beneficiary beneficiary = service.showWithId(b_id);
        return new ResponseEntity<>(beneficiary, HttpStatus.OK);
    }

    @PutMapping("/{b_id}")
    public ResponseEntity<Beneficiary> updateBeneficiary(@PathVariable UUID b_id, @RequestBody BeneficiaryRq rq){
        Beneficiary beneficiary = service.updateBeneficiary(b_id, rq);
        return new ResponseEntity<>(beneficiary, HttpStatus.OK);
    }

    @DeleteMapping("/{b_id}")
    public ResponseEntity<String> deleteBeneficiary(@PathVariable UUID b_id){
        service.deleteBeneficiary(b_id);
        return new ResponseEntity<>("Successful delete", HttpStatus.OK);
    }

}
