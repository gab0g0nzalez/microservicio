package com.donaton.inventario_service.client;

import com.donaton.inventario_service.dto.DonacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class DonacionClient {
    @Autowired
    private WebClient webClient;
    public DonacionDTO  getDonacionDTO(Integer id){
        return webClient.get().uri("/api/v1/donaciones/{id}",id).retrieve().bodyToMono(DonacionDTO.class).block();
    }
}
