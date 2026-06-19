package com.donaton.donacion_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(new Info().title("API Gestion de Donación").description("Microservicio para la gestion de donaciones y tipos de donaciones de DonatON").version("1.0"));
    }
}
