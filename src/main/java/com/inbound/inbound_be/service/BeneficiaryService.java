package com.inbound.inbound_be.service;

import com.inbound.inbound_be.dto.BeneficiaryRq;
import com.inbound.inbound_be.entity.Beneficiary;

import java.util.List;
import java.util.UUID;

public interface BeneficiaryService {

    Beneficiary addBeneficiary(BeneficiaryRq rq);
    List<Beneficiary> showAll ();

    Beneficiary showWithId(UUID b_id);
    Beneficiary updateBeneficiary (UUID b_id, BeneficiaryRq rq);

    void deleteBeneficiary(UUID b_id);

}
