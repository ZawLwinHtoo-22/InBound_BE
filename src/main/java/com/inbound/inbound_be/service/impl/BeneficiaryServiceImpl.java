package com.inbound.inbound_be.service.impl;

import com.inbound.inbound_be.dto.BeneficiaryRq;
import com.inbound.inbound_be.entity.Beneficiary;
import com.inbound.inbound_be.entity.Country;
import com.inbound.inbound_be.repo.BeneficiaryRepo;
import com.inbound.inbound_be.repo.CountryRepo;
import com.inbound.inbound_be.service.BeneficiaryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

    @Autowired
    private BeneficiaryRepo repo;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CountryRepo countryRepo;
    @Override
    public Beneficiary addBeneficiary(BeneficiaryRq rq) {
        Beneficiary beneficiary = mapper.map(rq, Beneficiary.class);
        Country country = countryRepo.findById(rq.getR_country())
                .orElseThrow(() -> new IllegalArgumentException("No Country"));
        beneficiary.setCountry(country);
        return repo.save(beneficiary);
    }

    @Override
    public List<Beneficiary> showAll() {
        return repo.findAll();
    }

    @Override
    public Beneficiary showWithId(UUID b_id) {
        return repo.findById(b_id)
                .orElseThrow(() -> new IllegalArgumentException("No Beneficiary Person"));

    }

    @Override
    public Beneficiary updateBeneficiary(UUID b_id, BeneficiaryRq rq) {
        Optional<Beneficiary> oldB = repo.findById(b_id);
        Country country = countryRepo.findById(rq.getR_country())
                .orElseThrow(() -> new IllegalArgumentException("No Country"));
        if(oldB.isPresent()){
            Beneficiary upB = oldB.get();
            upB.setB_name(rq.getB_name());
            upB.setB_date(rq.getB_date());
            upB.setB_nrc(rq.getB_nrc());
            upB.setB_rs(rq.getB_rs());
            upB.setB_ph(rq.getB_ph());
            upB.setB_email(rq.getB_email());
            upB.setCountry(country);
            return upB;
        }return null;
    }

    @Override
    public void deleteBeneficiary(UUID b_id) {
        if(repo.existsById(b_id)){
            repo.deleteById(b_id);
        }
    }
}
