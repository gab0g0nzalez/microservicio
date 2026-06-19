package com.donaton.usuarios_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(new Info().title("API Gestion de Usuario").version("1.0").description("Microservicio para la gestion de Usuarios y Roles de DonatON"));
    }
}
