package com.inbound.inbound_be.controller;

import com.inbound.inbound_be.domain.HtooResponse;
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
    public ResponseEntity<HtooResponse<Beneficiary>> addBeneficiary(@RequestBody BeneficiaryRq rq){
        Beneficiary beneficiary = service.addBeneficiary(rq);
        HtooResponse<Beneficiary> response =
                new HtooResponse<>(beneficiary, "Success Add", HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<HtooResponse<List<Beneficiary>>> showAll(){
        List<Beneficiary> beneficiaries = service.showAll();
        HtooResponse<List<Beneficiary>> response =
                new HtooResponse<>(beneficiaries, "Beneficiaries List", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{b_id}")
    public ResponseEntity<HtooResponse<Beneficiary>> showWithId(@PathVariable UUID b_id){
        Beneficiary beneficiary = service.showWithId(b_id);
        HtooResponse<Beneficiary> response =
                new HtooResponse<>(beneficiary, "Show With Beneficiary Id", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{b_id}")
    public ResponseEntity<HtooResponse<Beneficiary>> updateBeneficiary(@PathVariable UUID b_id, @RequestBody BeneficiaryRq rq){
        Beneficiary beneficiary = service.updateBeneficiary(b_id, rq);
        HtooResponse<Beneficiary> response =
                new HtooResponse<>(beneficiary, "Success update", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{b_id}")
    public ResponseEntity<String> deleteBeneficiary(@PathVariable UUID b_id){
        service.deleteBeneficiary(b_id);
        return new ResponseEntity<>("Successful delete", HttpStatus.OK);
    }

}
