package com.inbound.inbound_be.controller;

import com.inbound.inbound_be.dto.BeneficiaryRq;
import com.inbound.inbound_be.dto.ChildRequest;
import com.inbound.inbound_be.dto.Inbound_ProposalRequest;
import com.inbound.inbound_be.dto.InsuredPersonRq;
import com.inbound.inbound_be.entity.*;
import com.inbound.inbound_be.repo.AgentRepo;
import com.inbound.inbound_be.repo.Inbound_ProposalRepo;
import com.inbound.inbound_be.repo.PremiumRateRepo;
import com.inbound.inbound_be.service.BeneficiaryService;
import com.inbound.inbound_be.service.ChildService;
import com.inbound.inbound_be.service.Inbound_ProposalService;
import com.inbound.inbound_be.service.InsuredPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("inbounds")
public class Inbound_ProposalController {
    @Autowired
    private Inbound_ProposalService inboundProposalService;
    @Autowired
    private Inbound_ProposalRepo inboundProposalRepo;
    @Autowired
    private BeneficiaryService beneficiaryService;
    @Autowired
    private ChildService childService;
    @Autowired
    private InsuredPersonService insuredPersonService;
    @Autowired
    private PremiumRateRepo premiumRateRepo;
    @Autowired
    private AgentRepo agentRepo;
    @PostMapping
    public ResponseEntity<InBound_Proposal> createProposal(@RequestBody Inbound_ProposalRequest request){
        InBound_Proposal inBoundProposal=inboundProposalService.createProposal(request);
        BeneficiaryRq rq=new BeneficiaryRq(request.getB_name(),request.getB_date(),request.getB_nrc(),request.getB_rs(),
                request.getB_ph(),request.getB_email(),request.getB_address(),request.getB_country());
        Beneficiary beneficiary=beneficiaryService.addBeneficiary(rq);
        if(request.getIsChild() == true){
            ChildRequest childRequest=new ChildRequest(request.getCh_name(),request.getCh_dob(),request.getCh_gender(),
                    request.getCh_gu_Name(),request.getCh_rs());
            Child child=childService.addChild(childRequest);
            InsuredPersonRq insuredPersonRq=new InsuredPersonRq(request.getI_name(),request.getI_dob(),request.getI_gender(),
                    request.getI_phone(),request.getI_email(),request.getI_person_address(),request.getR_person_address(),request.getR_country(),
                    request.getI_passport_name(),request.getI_passport_issue_date(),request.getIsChild(),request.getCh_fk(),beneficiary.getB_id());
            InsuredPerson insuredPerson=insuredPersonService.addInsuredPerson(insuredPersonRq);
            inBoundProposal.setInsuredPerson(insuredPerson);
        }else {

        }
        LocalDate now=LocalDate.now();
        Integer currentYear=now.getYear();
        Integer birthYear=request.getI_dob().getYear();
        Integer age=currentYear-birthYear;
        Double premium=premiumRateRepo.findPremiumRateByPolicyDaysAndFromAgeAndToAge(age,request.getCo_plan());
        inBoundProposal.setPre_rate(premium);
        Optional<Agent> agent=agentRepo.findById(request.getAgent_id());
        inBoundProposal.setAgent(agent.get());

        return new ResponseEntity<>(inboundProposalRepo.save(inBoundProposal), HttpStatus.CREATED);
    }
}
