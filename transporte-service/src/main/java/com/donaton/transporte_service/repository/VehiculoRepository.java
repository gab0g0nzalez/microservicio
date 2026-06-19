package com.donaton.transporte_service.repository;

import com.donaton.transporte_service.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo,Integer> {
}
