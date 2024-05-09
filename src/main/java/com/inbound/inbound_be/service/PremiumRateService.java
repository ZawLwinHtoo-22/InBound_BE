package com.inbound.inbound_be.service;

import com.inbound.inbound_be.dto.PremiumRequest;
import com.inbound.inbound_be.dto.PremiumResponse;

public interface PremiumRateService {
    PremiumResponse getByAge(PremiumRequest request);
}
