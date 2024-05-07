package com.inbound.inbound_be.service.impl;

import com.inbound.inbound_be.dto.Inbound_ProposalRequest;
import com.inbound.inbound_be.entity.InBound_Proposal;
import com.inbound.inbound_be.repo.Inbound_ProposalRepo;
import com.inbound.inbound_be.service.Inbound_ProposalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Inbound_ProposalServiceImpl implements Inbound_ProposalService {
    @Autowired
    private Inbound_ProposalRepo inboundProposalRepo;
    @Autowired
    private ModelMapper mapper;
    @Override
    public InBound_Proposal createProposal(Inbound_ProposalRequest request) {
        return null;
    }
}
