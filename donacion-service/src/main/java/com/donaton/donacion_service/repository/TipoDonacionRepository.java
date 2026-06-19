package com.donaton.donacion_service.repository;

import com.donaton.donacion_service.model.TipoDonacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDonacionRepository extends JpaRepository<TipoDonacion,Integer> {
}
