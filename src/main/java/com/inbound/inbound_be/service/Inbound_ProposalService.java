package com.inbound.inbound_be.service;

import com.inbound.inbound_be.dto.InBound_ValidationRq;
import com.inbound.inbound_be.dto.Inbound_ProposalRequest;
import com.inbound.inbound_be.entity.InBound_Proposal;
import com.inbound.inbound_be.entity.InsuredPerson;

import java.util.List;
import java.util.Optional;

public interface Inbound_ProposalService {
    InBound_Proposal createProposal(Inbound_ProposalRequest request);
    List<InBound_Proposal> showAll();
    List<InBound_Proposal> validateRq(InBound_ValidationRq rq);

}
