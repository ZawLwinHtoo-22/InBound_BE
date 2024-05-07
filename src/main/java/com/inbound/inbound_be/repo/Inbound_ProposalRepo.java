package com.inbound.inbound_be.repo;

import com.inbound.inbound_be.entity.InBound_Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Inbound_ProposalRepo extends JpaRepository<InBound_Proposal, UUID> {
}
