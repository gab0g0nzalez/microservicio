package com.donaton.distribucion_service.client;

import com.donaton.distribucion_service.dto.BeneficiarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BeneficiarioClient {
    @Autowired
    private WebClient webClient;
    public BeneficiarioDTO getBeneficiarioDTO(Integer id) {
        return webClient.get().uri("/api/v1/beneficiarios/{id}", id).retrieve().bodyToMono(BeneficiarioDTO.class).block();
    }
}
