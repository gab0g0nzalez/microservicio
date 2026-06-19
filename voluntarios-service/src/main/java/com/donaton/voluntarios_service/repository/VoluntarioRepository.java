package com.donaton.voluntarios_service.repository;

import com.donaton.voluntarios_service.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoluntarioRepository
        extends JpaRepository<Voluntario,Integer> {
}
