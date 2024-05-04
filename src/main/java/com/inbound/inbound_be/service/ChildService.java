package com.inbound.inbound_be.service;

import com.inbound.inbound_be.dto.ChildRequest;
import com.inbound.inbound_be.entity.Child;

import java.util.List;
import java.util.UUID;

public interface ChildService {

    Child addChild(ChildRequest request);
    List<Child> showAll();
    Child showWithId(UUID ch_id);

    Child update(UUID ch_id, ChildRequest request);
    void delete(UUID ch_id);
}
