package com.inbound.inbound_be.service.impl;

import com.inbound.inbound_be.dto.InsuredPersonRq;
import com.inbound.inbound_be.dto.InsuredPersonRqWithoutChild;
import com.inbound.inbound_be.entity.Beneficiary;
import com.inbound.inbound_be.entity.Child;
import com.inbound.inbound_be.entity.InsuredPerson;
import com.inbound.inbound_be.repo.BeneficiaryRepo;
import com.inbound.inbound_be.repo.ChildRepo;
import com.inbound.inbound_be.repo.InsuredPersonRepo;
import com.inbound.inbound_be.service.InsuredPersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class InsuredPersonServiceImpl implements InsuredPersonService {

    @Autowired
    private InsuredPersonRepo insuredPersonRepo;

    @Autowired
    private ChildRepo childRepo;

    @Autowired
    private BeneficiaryRepo beneficiaryRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public InsuredPerson addInsuredPerson(InsuredPersonRq rq) {
        InsuredPerson insuredPerson = mapper.map(rq, InsuredPerson.class);
        Beneficiary beneficiary = beneficiaryRepo.findById(rq.getB_fk())
                .orElseThrow(() -> new IllegalArgumentException("Invalid BeneficiaryId "+ rq.getB_fk()));
        insuredPerson.setBeneficiary(beneficiary);
        Child child=childRepo.getReferenceById(rq.getCh_fk());
//        if(rq.getIsChild() == true)t{
//
//            Child child = childRepo.findById();
//        }
//        InsuredPerson insuredPerson = insuredPersonRepo.findForeignKeyWhenBooleanColumnIsTrue()
//                .orElseThrow().getInsuredPerson();
//        i.setCh_fk(insuredPerson.getCh_fk());


        return insuredPersonRepo.save(insuredPerson);
    }

    @Override
    public InsuredPerson addWithoutChild(InsuredPersonRqWithoutChild rqWithoutChild) {
        InsuredPerson insuredPerson=mapper.map(rqWithoutChild, InsuredPerson.class);
        return insuredPersonRepo.save(insuredPerson);
    }

    @Override
    public List<InsuredPerson> showAll() {
        return insuredPersonRepo.findAll();
    }

    @Override
    public InsuredPerson showWithId(UUID i_id) {
        return insuredPersonRepo.findById(i_id)
                .orElseThrow( () -> new IllegalArgumentException("No InsuredPersonId"));
    }

    @Override
    public InsuredPerson update(UUID i_id, InsuredPersonRq rq) {
        return null;
    }

    @Override
    public void delete(UUID i_id) {
        if(insuredPersonRepo.existsById(i_id)){
            insuredPersonRepo.deleteById(i_id);
        }
    }
}
