package com.donaton.distribucion_service.repository;

import com.donaton.distribucion_service.model.Distribucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistribucionRepository
        extends JpaRepository<Distribucion,Integer> {
}