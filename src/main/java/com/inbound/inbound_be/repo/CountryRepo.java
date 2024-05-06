package com.inbound.inbound_be.repo;

import com.inbound.inbound_be.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountryRepo extends JpaRepository<Country, UUID> {
}
