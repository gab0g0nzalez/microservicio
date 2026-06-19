package com.donaton.beneficiarios_service.service;

import com.donaton.beneficiarios_service.model.Comuna;
import com.donaton.beneficiarios_service.repository.ComunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComunaService {
    @Autowired
    private ComunaRepository repository;

    public List<Comuna> getComunas(){
        return repository.findAll();
    }

    public Optional<Comuna> getComuna(Integer id){return repository.findById(id);}

    public Comuna saveComuna(Comuna comuna){return repository.save(comuna);}

    public void deleteComuna(Integer id){
        if (repository.existsById(id)){
            repository.deleteById(id);}
        else{
            throw new RuntimeException("No encontrado");
        }
    }
}
