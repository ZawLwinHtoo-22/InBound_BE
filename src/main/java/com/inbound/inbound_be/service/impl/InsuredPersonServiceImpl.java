package com.inbound.inbound_be.service.impl;

import com.inbound.inbound_be.dto.InsuredPersonRq;
import com.inbound.inbound_be.entity.Beneficiary;
import com.inbound.inbound_be.entity.Child;
import com.inbound.inbound_be.entity.Country;
import com.inbound.inbound_be.entity.InsuredPerson;
import com.inbound.inbound_be.repo.BeneficiaryRepo;
import com.inbound.inbound_be.repo.ChildRepo;
import com.inbound.inbound_be.repo.CountryRepo;
import com.inbound.inbound_be.repo.InsuredPersonRepo;
import com.inbound.inbound_be.service.InsuredPersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class InsuredPersonServiceImpl implements InsuredPersonService {

    @Autowired
    private InsuredPersonRepo insuredPersonRepo;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private BeneficiaryRepo beneficiaryRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ChildRepo childRepo;
    @Override
    public InsuredPerson addInsuredPerson(InsuredPersonRq rq) {
        InsuredPerson insuredPerson = mapper.map(rq, InsuredPerson.class);
        Beneficiary beneficiary = beneficiaryRepo.findById(rq.getB_fk())
                .orElseThrow(() -> new IllegalArgumentException("Invalid BeneficiaryId "+ rq.getB_fk()));
        insuredPerson.setBeneficiary(beneficiary);
//        if(rq.getIsChild() == true)t{
//
//            Child child = childRepo.findById();
//        }
//        InsuredPerson insuredPerson = insuredPersonRepo.findForeignKeyWhenBooleanColumnIsTrue()
//                .orElseThrow().getInsuredPerson();
//        i.setCh_fk(insuredPerson.getCh_fk());


        Country country = countryRepo.findById(rq.getR_country())
                .orElseThrow(() -> new IllegalArgumentException("NO Country"));
        insuredPerson.setCountry(country);

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
       Optional<InsuredPerson> insuredPerson = insuredPersonRepo.findById(i_id);
       Optional<Beneficiary> beneficiary = beneficiaryRepo.findById(rq.getB_fk());
       Country country = countryRepo.findById(rq.getR_country())
               .orElseThrow(() -> new IllegalArgumentException("No Country"));
           if(insuredPerson.isPresent()){
               InsuredPerson up = insuredPerson.get();
               up.setI_name(rq.getI_name());
               up.setIsChild(rq.getIsChild());
               up.setI_dob(rq.getI_dob());
               up.setI_email(rq.getI_email());
               up.setI_gender(rq.getI_gender());
               up.setI_phone(rq.getI_phone());
               up.setI_passport_issue_date(rq.getI_passport_issue_date());
               up.setI_passport_name(rq.getI_passport_name());
               up.setI_person_address(rq.getI_person_address());
               up.setR_person_address(rq.getR_person_address());
               up.setBeneficiary(beneficiary.get());
               up.setCountry(country);

               return up;
           }return null;
    }

    @Override
    public void delete(UUID i_id) {
        if(insuredPersonRepo.existsById(i_id)){
            insuredPersonRepo.deleteById(i_id);
        }
    }
}
