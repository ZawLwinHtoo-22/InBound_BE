package com.inbound.inbound_be.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentValidateRq {

    private Integer licenseNo;
    private Integer password;
}
