package com.donaton.donacion_service.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClientUsuarios() {
        return WebClient.builder().baseUrl("http://localhost:8089").build();
    }

}
