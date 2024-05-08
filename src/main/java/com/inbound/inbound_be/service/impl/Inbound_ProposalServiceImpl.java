package com.inbound.inbound_be.service.impl;

import com.inbound.inbound_be.dto.InBound_ValidationRq;
import com.inbound.inbound_be.dto.Inbound_ProposalRequest;
import com.inbound.inbound_be.entity.InBound_Proposal;
import com.inbound.inbound_be.entity.InsuredPerson;
import com.inbound.inbound_be.repo.Inbound_ProposalRepo;
import com.inbound.inbound_be.repo.InsuredPersonRepo;
import com.inbound.inbound_be.service.Inbound_ProposalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Inbound_ProposalServiceImpl implements Inbound_ProposalService {
    @Autowired
    private Inbound_ProposalRepo inboundProposalRepo;
    @Autowired
    private InsuredPersonRepo repo;
    @Autowired
    private ModelMapper mapper;
    @Override
    public InBound_Proposal createProposal(Inbound_ProposalRequest request) {
        InBound_Proposal inBoundProposal=mapper.map(request, InBound_Proposal.class);
        return inBoundProposal;
    }

    @Override
    public List<InBound_Proposal> showAll() {
        List<InBound_Proposal> inBoundProposals = inboundProposalRepo.findAll();
        return inBoundProposals;
    }

//    @Override
//    public List<InBound_Proposal> validateRq(InBound_ValidationRq rq) {
//        InBound_Proposal inBoundProposal = inboundProposalRepo.
//        return null;
//    }


    @Override
    public List<InBound_Proposal> validateRq(InBound_ValidationRq validationRq) {
//            InBound_Proposal inBoundProposal = inboundProposalRepo.
//                    findInBound_ProposalByPassportNumberAndPassportCountry(validationRq.getPassportNumber(),validationRq.getPassportCountry());
        List<InBound_Proposal> inBoundProposals = inboundProposalRepo.findAll();
        List<InBound_Proposal> inBoundProposals1 = new ArrayList<>();
        for (InBound_Proposal inBoundProposal1 : inBoundProposals) {
            if (inBoundProposal1.getPassportNumber().equals(validationRq.getPassportNumber()) &&
                    inBoundProposal1.getPassportCountry().equals(validationRq.getPassportCountry())) {
                inBoundProposals1.add(inBoundProposal1);
            }}
            return inBoundProposals1.isEmpty() ? null : inBoundProposals1;


        }
    }