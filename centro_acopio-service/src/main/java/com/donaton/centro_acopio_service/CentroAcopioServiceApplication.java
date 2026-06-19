package com.donaton.centro_acopio_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CentroAcopioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentroAcopioServiceApplication.class, args);
	}

}
