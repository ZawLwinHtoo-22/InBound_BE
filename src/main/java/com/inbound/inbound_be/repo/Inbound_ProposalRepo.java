package com.inbound.inbound_be.repo;

import com.inbound.inbound_be.dto.InBound_ValidationRq;
import com.inbound.inbound_be.entity.InBound_Proposal;
import com.inbound.inbound_be.entity.InsuredPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Inbound_ProposalRepo extends JpaRepository<InBound_Proposal, UUID> {

    InBound_Proposal findInBound_ProposalByPassportNumberAndPassportCountry(String passportNumber,String passportCountry);
}
