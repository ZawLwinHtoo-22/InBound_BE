package com.inbound.inbound_be.repo;

import com.inbound.inbound_be.entity.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeneficiaryRepo extends JpaRepository<Beneficiary, UUID> {
}
