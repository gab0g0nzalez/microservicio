package com.donaton.distribucion_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DistribucionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistribucionServiceApplication.class, args);
	}

}
