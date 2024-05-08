package com.inbound.inbound_be.repo;

import com.inbound.inbound_be.entity.Child;
import com.inbound.inbound_be.entity.InsuredPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InsuredPersonRepo extends JpaRepository<InsuredPerson, UUID> {

    InsuredPerson findInsuredPersonByPassportNumberAndPassportCountry(String passportNumber, String passportCountry);


}
