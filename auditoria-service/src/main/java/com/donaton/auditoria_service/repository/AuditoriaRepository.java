package com.donaton.auditoria_service.repository;

import com.donaton.auditoria_service.model.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriaRepository extends JpaRepository<Auditoria,Integer> {
}
