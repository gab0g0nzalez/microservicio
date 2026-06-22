package com.donaton.centro_acopio_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(new Info().title("API Gestion de los Beneficiarios").version("1.0").description("Microservicio para la gestion de los Centro Acopio de DonatON"));
    }
}