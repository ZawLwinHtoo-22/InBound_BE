package com.inbound.inbound_be.controller;

import com.inbound.inbound_be.dto.ChildRequest;
import com.inbound.inbound_be.entity.Child;
import com.inbound.inbound_be.service.ChildService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/child")
@CrossOrigin
@Transactional
public class ChildController {

    @Autowired
    private ChildService service;
    @PostMapping
    public ResponseEntity<Child> addChild(@RequestBody ChildRequest request){
        Child child1 = service.addChild(request);
        return new ResponseEntity<>(child1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Child>> showAll(){
        List<Child> childList = service.showAll();
        return new ResponseEntity<>(childList, HttpStatus.OK);
    }

    @GetMapping("/{ch_id}")
    public ResponseEntity<Child> showWithId(@PathVariable UUID ch_id){
        Child child = service.showWithId(ch_id);
        return new ResponseEntity<>(child, HttpStatus.OK);
    }
    @PutMapping("/{ch_id}")
    public ResponseEntity<Child> update(@PathVariable UUID ch_id, @RequestBody ChildRequest request){
        Child child = service.update(ch_id, request);
        return new ResponseEntity<>(child, HttpStatus.OK);
    }
    @DeleteMapping("/{ch_id}")
    public ResponseEntity<String> delete(@PathVariable UUID ch_id){
        service.delete(ch_id);
        return new ResponseEntity<>("Successfully delete", HttpStatus.OK);
    }


}
