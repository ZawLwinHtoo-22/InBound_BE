package com.inbound.inbound_be.service.impl;

import com.inbound.inbound_be.dto.ChildRequest;
import com.inbound.inbound_be.entity.Child;
import com.inbound.inbound_be.entity.InsuredPerson;
import com.inbound.inbound_be.repo.ChildRepo;
import com.inbound.inbound_be.repo.InsuredPersonRepo;
import com.inbound.inbound_be.service.ChildService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private ChildRepo childRepo;

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private InsuredPersonRepo repo;


    @Override
    public Child addChild(ChildRequest request) {
        Child child = mapper.map(request, Child.class);
        Optional<InsuredPerson> insuredPerson=repo.findById(request.getI_person_fk());
        child.setInsuredPerson(insuredPerson.get());
        return childRepo.save(child);
    }

    @Override
    public List<Child> showAll() {
        List<Child> childList = childRepo.findAll();

            if(childList.isEmpty()){
                System.out.println("No data");
            }

        return childList;
    }

    @Override
    public Child showWithId(UUID ch_id) {
        return childRepo
                .findById(ch_id)
                .orElseThrow( () -> new IllegalArgumentException("No Child"));
    }


    @Override
    public Child update(UUID ch_id, ChildRequest request) {
        Optional<Child> child =  childRepo.findById(ch_id);
        InsuredPerson insuredPerson = repo.findById(request.getI_person_fk())
                .orElseThrow(() -> new IllegalArgumentException("No InsuredPerson"));
        if(child.isPresent()){
            Child upChild =  child.get();
            upChild.setCh_name(request.getCh_name());
            upChild.setCh_gu_Name(request.getCh_gu_Name());
            upChild.setCh_rs(request.getCh_rs());
            upChild.setCh_dob(request.getCh_dob());
            upChild.setCh_gender(request.getCh_gender());
            upChild.setInsuredPerson(insuredPerson);
            return upChild;
        }
            return null;
    }

    @Override
    public void delete(UUID ch_id) {
       if(childRepo.existsById(ch_id)){
           childRepo.deleteById(ch_id);
       }

    }
}
