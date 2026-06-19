package com.donaton.auditoria_service.client;

import com.donaton.auditoria_service.dto.UsuariosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UsuariosClient {
    @Autowired
    private WebClient webClient;
    public UsuariosDTO getUsuariosDTO(Integer id){
        return webClient.get().uri("/api/v1/usuarios/{id}", id)
                .retrieve().bodyToMono(UsuariosDTO.class).block();
    }
}
