package com.inbound.inbound_be.repo;

import com.inbound.inbound_be.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ChildRepo extends JpaRepository<Child, UUID> {



}
