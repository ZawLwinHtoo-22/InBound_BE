package com.inbound.inbound_be.controller;

import com.inbound.inbound_be.dto.InsuredPersonRq;
import com.inbound.inbound_be.entity.InsuredPerson;
import com.inbound.inbound_be.service.InsuredPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


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

    @GetMapping("/{i_id}")
    public ResponseEntity<InsuredPerson> showWithId(@PathVariable UUID i_id){
        InsuredPerson insuredPerson = service.showWithId(i_id);
        return new ResponseEntity<>(insuredPerson, HttpStatus.OK);
    }

    @PutMapping("/{i_id}")
    public ResponseEntity<InsuredPerson> updateInsuredPerson(@PathVariable UUID i_id, @RequestBody InsuredPersonRq rq){
        InsuredPerson insuredPerson = service.update(i_id, rq);
        return new ResponseEntity<>(insuredPerson, HttpStatus.OK);
    }

    @DeleteMapping("/{i_id}")
    public ResponseEntity<String> delete(@PathVariable UUID i_id){
        service.delete(i_id);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }
}
