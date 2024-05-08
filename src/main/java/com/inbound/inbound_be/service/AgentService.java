package com.inbound.inbound_be.service;

import com.inbound.inbound_be.dto.AgentRequest;
import com.inbound.inbound_be.dto.AgentValidateRq;
import com.inbound.inbound_be.entity.Agent;

import java.util.List;
import java.util.UUID;

public interface AgentService {

    Agent addAgent(Agent agent);
    List<Agent> showAll();
    Agent showWithId(UUID a_id);

    Agent update(UUID a_id, AgentRequest request);
    void delete(UUID a_id);
    Agent validateAgent(AgentValidateRq validateRq);

}
