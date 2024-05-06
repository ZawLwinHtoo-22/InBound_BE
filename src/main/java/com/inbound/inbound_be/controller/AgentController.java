package com.inbound.inbound_be.controller;

import com.inbound.inbound_be.dto.AgentInfo;
import com.inbound.inbound_be.dto.AgentRequest;
import com.inbound.inbound_be.dto.AgentValidateRq;
import com.inbound.inbound_be.entity.Agent;
import com.inbound.inbound_be.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentService service;

    @PostMapping
    public ResponseEntity<Agent> addAgent(@RequestBody AgentRequest request){
       Agent agent = service.addAgent(request);
        return new ResponseEntity<>(agent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Agent>> showAll(){
        List<Agent> agents = service.showAll();
        return new ResponseEntity<>(agents, HttpStatus.OK);
    }
    @GetMapping("/{a_id}")
    public ResponseEntity<Agent> showWithId(@PathVariable UUID a_id){
        Agent agent = service.showWithId(a_id);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }

    @PutMapping("/{a_id}")
    public ResponseEntity<Agent> update(@PathVariable UUID a_id, @RequestBody AgentRequest request){
        Agent agent = service.update(a_id, request);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }

    @DeleteMapping("/{a_id}")
    public ResponseEntity<String> delete(@PathVariable UUID a_id){
        service.delete(a_id);
        return new ResponseEntity<>("Successfully Delete", HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity<Agent> validateAgent(@RequestBody AgentValidateRq validateRq){
        return ResponseEntity.ok(service.validateAgent(validateRq));
    }


}
