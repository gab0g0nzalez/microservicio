package com.donaton.donacion_service.repository;

import com.donaton.donacion_service.model.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonacionRepository extends JpaRepository<Donacion,Integer> {
}
