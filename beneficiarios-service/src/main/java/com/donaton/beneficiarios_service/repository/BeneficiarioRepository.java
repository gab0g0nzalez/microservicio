package com.donaton.beneficiarios_service.repository;

import com.donaton.beneficiarios_service.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository
        extends JpaRepository<Beneficiario,Integer> {
}
