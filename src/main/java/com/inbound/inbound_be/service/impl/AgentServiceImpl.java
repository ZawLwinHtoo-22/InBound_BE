package com.inbound.inbound_be.service.impl;

import com.inbound.inbound_be.dto.AgentInfo;
import com.inbound.inbound_be.dto.AgentRequest;
import com.inbound.inbound_be.dto.AgentValidateRq;
import com.inbound.inbound_be.entity.Agent;
import com.inbound.inbound_be.repo.AgentRepo;
import com.inbound.inbound_be.service.AgentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepo repo;
    @Autowired
    private ModelMapper mapper;
    @Override
    public Agent addAgent(AgentRequest request) {
       Agent addAgent = Agent.of(request);
       return mapper.map(repo.save(addAgent), Agent.class);

    }

    @Override
    public List<Agent> showAll() {
        return repo.findAll();
    }

    @Override
    public Agent showWithId(UUID a_id) {
        return repo
                .findById(a_id)
                .orElseThrow( () -> new IllegalArgumentException("No Agent"));
    }

    @Override
    public Agent update(UUID a_id, AgentRequest request) {
        Optional<Agent> oldAgent = repo.findById(a_id);
        if(oldAgent.isPresent()){
            Agent upAgent = oldAgent.get();
            upAgent.setA_name(request.getA_name());
            upAgent.setLicenseNo(request.getLicenseNo());
            upAgent.setPassword(request.getPassword());
            return upAgent;
        }
        return null;
    }

    @Override
    public void delete(UUID a_id) {
        if(repo.existsById(a_id)){
            repo.deleteById(a_id);
        }
    }

    @Override
    public AgentInfo validateAgent(AgentValidateRq validateRq) {
        final Agent agent = repo
                .findAgentByLicenseNoAndPassword(validateRq.getLicenseNo(), validateRq.getPassword())
                .orElseThrow( () -> new RuntimeException("No Agent"));

        return AgentInfo.of(agent);

    }
}
