package com.inbound.inbound_be.service;

import com.inbound.inbound_be.dto.InsuredPersonRq;
import com.inbound.inbound_be.dto.InsuredPersonRqWithoutChild;
import com.inbound.inbound_be.entity.InsuredPerson;

import java.util.List;
import java.util.UUID;

public interface InsuredPersonService {

    InsuredPerson addInsuredPerson(InsuredPersonRq rq);
    InsuredPerson addWithoutChild(InsuredPersonRqWithoutChild rqWithoutChild);
    List<InsuredPerson> showAll();

    InsuredPerson showWithId(UUID i_id);

//    i - insured person
    InsuredPerson update(UUID i_id, InsuredPersonRq rq);

    void delete(UUID i_id);
}
