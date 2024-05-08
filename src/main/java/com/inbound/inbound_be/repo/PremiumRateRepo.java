package com.inbound.inbound_be.repo;

import com.inbound.inbound_be.entity.PremiumRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PremiumRateRepo extends JpaRepository<PremiumRate, UUID> {
    @Query("SELECT p.pre_rate from PremiumRate p where :age between p.fromAge and p.toAge and :co_plan=p.policyDays")
    Double findPremiumRateByPolicyDaysAndFromAgeAndToAge(@Param("age")Integer age, @Param("co_plan")Integer co_plan);
}
