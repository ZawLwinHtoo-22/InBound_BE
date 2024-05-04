package com.inbound.inbound_be.repo;

import com.inbound.inbound_be.entity.Child;
import com.inbound.inbound_be.entity.InsuredPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface InsuredPersonRepo extends JpaRepository<InsuredPerson, UUID> {

    @Query("SELECT b.ch_id FROM InsuredPerson a JOIN Child b ON a.isChild = true AND a.ch_fk = b.ch_id")
    Optional<Child> findForeignKeyWhenBooleanColumnIsTrue();
}
