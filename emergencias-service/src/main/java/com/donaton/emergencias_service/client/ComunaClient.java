package com.donaton.emergencias_service.client;

import com.donaton.emergencias_service.dto.ComunaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ComunaClient {
    @Autowired
    private WebClient webClient;
    public ComunaDTO getComuna(Integer id) {
        return webClient.get().uri("/api/v1/comunas/{id}" , id).retrieve().bodyToMono(ComunaDTO.class).block();
    }
}
