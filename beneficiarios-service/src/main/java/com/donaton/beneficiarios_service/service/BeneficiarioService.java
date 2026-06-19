package com.donaton.beneficiarios_service.service;


import com.donaton.beneficiarios_service.model.Beneficiario;
import com.donaton.beneficiarios_service.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService {
    @Autowired
    private BeneficiarioRepository repository;


    public List<Beneficiario> getBeneficiarios() {
        return repository.findAll();

    }

    public Optional<Beneficiario> getBeneficiario(Integer id) {
        return repository.findById(id);
    }

    public Beneficiario saveBeneficiario(Beneficiario beneficiario) {
        return repository.save(beneficiario);
    }

    public void delete(Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);}
        else {
            throw new RuntimeException("No encontrado");
        }
    }
}