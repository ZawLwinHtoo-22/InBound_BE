package com.inbound.inbound_be.controller;

import com.inbound.inbound_be.domain.HtooResponse;
import com.inbound.inbound_be.dto.*;
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
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inbounds")
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
                request.getB_ph(),request.getB_email(),request.getB_address(),request.getR_country_b());
        Beneficiary beneficiary=beneficiaryService.addBeneficiary(rq);

            InsuredPersonRq insuredPersonRq=new InsuredPersonRq(request.getI_name(),request.getI_dob(),request.getI_gender(),
                    request.getI_phone(),request.getI_email(),request.getI_person_address(),request.getR_person_address(),
                    request.getPassportNumber(),request.getI_passport_issue_date(),request.getIsChild(),request.getPassportCountry(),beneficiary.getB_id(),request.getR_country_i());
            InsuredPerson insuredPerson=insuredPersonService.addInsuredPerson(insuredPersonRq);
        inBoundProposal.setInsuredPerson(insuredPerson);
        if(request.getIsChild() == true){
            ChildRequest childRequest=new ChildRequest(request.getCh_name(),request.getCh_dob(),request.getCh_gender(),
                    request.getCh_gu_Name(),request.getCh_rs(),insuredPerson.getI_person_id());
            Child child=childService.addChild(childRequest);
        }else {
            System.out.println("No child");
        }
        Agent agent=agentRepo.findAgentByLicenseNo(request.getLicenseNo());
        inBoundProposal.setAgent(agent);
        inBoundProposal.setP_st_date(LocalDate.now());
        inBoundProposal.setP_en_date(LocalDate.now().plusDays(request.getCo_plan()));
        inBoundProposal.setPro_date(LocalDate.now());
        return new ResponseEntity<>(inboundProposalRepo.save(inBoundProposal), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InBound_Proposal>> showAll(){
        List<InBound_Proposal> inBoundProposalList = inboundProposalService.showAll();
        return new ResponseEntity<>(inBoundProposalList, HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity<List<InBound_Proposal>> validate(@RequestBody InBound_ValidationRq rq){
        List<InBound_Proposal> inBoundProposal = inboundProposalService.validateRq(rq);
        return new ResponseEntity<>(inBoundProposal, HttpStatus.OK);
    }

}
