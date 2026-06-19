package com.donaton.beneficiarios_service.repository;

import com.donaton.beneficiarios_service.model.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComunaRepository extends JpaRepository<Comuna, Integer> {
}
