package com.inbound.inbound_be.service.impl;

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
    public Agent addAgent(Agent agent) {
        try {
            // Check if an agent with the same license number already exists
            Agent existingAgent = repo.findByLicenseNo(agent.getLicenseNo());
            if (existingAgent != null) {
                // An agent with the same license number already exists, throw an exception or handle the error
                throw new IllegalArgumentException("Agent with the same license number already exists");
            }

            // No agent with the same license number found, proceed to save the new agent
            Agent addAgent = Agent.of(agent);
            return mapper.map(repo.save(addAgent), Agent.class);
        } catch (IllegalArgumentException ex) {
            // Handle the exception, you can log the error or perform any necessary actions
            ex.printStackTrace(); // Example: Print the stack trace
            // Optionally, you can re-throw the exception to propagate it to the caller
            throw ex;
        }


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
    public Agent validateAgent(AgentValidateRq validateRq) {
        final Agent agent = repo
                .findAgentByLicenseNoAndPassword(validateRq.getLicenseNo(), validateRq.getPassword())
                .orElseThrow( () -> new RuntimeException("No Agent"));

        return agent;

    }
}
