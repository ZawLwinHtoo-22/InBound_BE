package com.inbound.inbound_be.service.impl;

import com.inbound.inbound_be.dto.ChildRequest;
import com.inbound.inbound_be.dto.PremiumRequest;
import com.inbound.inbound_be.dto.PremiumResponse;
import com.inbound.inbound_be.entity.Child;
import com.inbound.inbound_be.repo.PremiumRateRepo;
import com.inbound.inbound_be.service.PremiumRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PremiumRateServiceImpl implements PremiumRateService {
    @Autowired
    private PremiumRateRepo repo;
    @Override
    public PremiumResponse getByAge(PremiumRequest request) {
        PremiumResponse response=new PremiumResponse();
        LocalDate now=LocalDate.now();
        Integer currentYear=now.getYear();
        if(request.getIsChild() == true){
            Integer birthYear=request.getCh_dob().getYear();
            Integer age=currentYear-birthYear;
            Double premium=repo.findPremiumRateByPolicyDaysAndFromAgeAndToAge(age,request.getCo_plan());
            response.setPremium(premium);
            response.setAge(age);
        }else {
            Integer birthYear=request.getI_dob().getYear();
            Integer age=currentYear-birthYear;
            Double premium=repo.findPremiumRateByPolicyDaysAndFromAgeAndToAge(age,request.getCo_plan());
            response.setPremium(premium);
            response.setAge(age);
        }
        return response;
    }
}
