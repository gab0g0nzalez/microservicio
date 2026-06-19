package com.donaton.voluntarios_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(new Info().title("API Gestion de Voluntario").version("1.0").description("Microservicio para la gestion de Voluntarios de DonatON"));
    }
}
