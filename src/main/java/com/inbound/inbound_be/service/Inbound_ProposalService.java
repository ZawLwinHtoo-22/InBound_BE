package com.inbound.inbound_be.service;

import com.inbound.inbound_be.dto.Inbound_ProposalRequest;
import com.inbound.inbound_be.entity.InBound_Proposal;

public interface Inbound_ProposalService {
    InBound_Proposal createProposal(Inbound_ProposalRequest request);
}
