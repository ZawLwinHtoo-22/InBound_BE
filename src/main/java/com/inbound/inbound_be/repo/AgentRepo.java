package com.inbound.inbound_be.repo;

import com.inbound.inbound_be.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AgentRepo extends JpaRepository<Agent, UUID> {
    Optional<Agent> findAgentByLicenseNoAndPassword(Integer licenseNo, Integer password);

    Agent findAgentByLicenseNo(Integer licenseNo);

}
