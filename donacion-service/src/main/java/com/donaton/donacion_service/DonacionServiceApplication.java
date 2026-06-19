package com.donaton.donacion_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class DonacionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonacionServiceApplication.class, args);
	}

}
