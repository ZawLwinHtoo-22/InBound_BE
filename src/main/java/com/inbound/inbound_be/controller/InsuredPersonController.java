package com.inbound.inbound_be.controller;

import com.inbound.inbound_be.dto.InsuredPersonRq;
import com.inbound.inbound_be.entity.InsuredPerson;
import com.inbound.inbound_be.service.InsuredPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/insuredperson")
public class InsuredPersonController {

    @Autowired
    private InsuredPersonService service;

    @PostMapping
    public ResponseEntity<InsuredPerson> addInsuredPerson(@RequestBody InsuredPersonRq rq){
        InsuredPerson insuredPerson = service.addInsuredPerson(rq);
        return new ResponseEntity<>(insuredPerson, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InsuredPerson>> showAll(){
        List<InsuredPerson> insuredPersonList = service.showAll();
        return new ResponseEntity<>(insuredPersonList, HttpStatus.OK);
    }
}
