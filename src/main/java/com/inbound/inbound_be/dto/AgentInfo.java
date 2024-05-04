package com.inbound.inbound_be.dto;

import com.inbound.inbound_be.entity.Agent;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AgentInfo {

    private UUID a_id;

    public static AgentInfo of (Agent agent){
        AgentInfo agentInfo = new AgentInfo();
        agentInfo.a_id = agent.getA_id();

        return agentInfo;
    }

}
