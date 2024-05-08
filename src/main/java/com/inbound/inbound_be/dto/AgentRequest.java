package com.inbound.inbound_be.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AgentRequest {

    private String a_name;
    private Integer licenseNo;
    private Integer password;


}
