package com.donaton.voluntarios_service.client;

import com.donaton.voluntarios_service.dto.EmergenciasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class EmergenciaClient {
    @Autowired
    private WebClient webClient;
public EmergenciasDTO getEmergenciasDTO(Integer id){
    return webClient.get().uri("/api/v1/emergencias/{id}", id).retrieve().bodyToMono(EmergenciasDTO.class).block();
}
}
