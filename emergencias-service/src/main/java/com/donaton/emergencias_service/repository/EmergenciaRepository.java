package com.donaton.emergencias_service.repository;

import com.donaton.emergencias_service.model.Emergencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergenciaRepository extends JpaRepository<Emergencia,Integer> {

}
