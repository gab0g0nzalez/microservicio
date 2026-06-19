package com.donaton.beneficiarios_service.service;


import com.donaton.beneficiarios_service.model.Region;
import com.donaton.beneficiarios_service.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
    @Autowired
    private RegionRepository repository;

    public List<Region> getRegiones(){
        return repository.findAll();
    }

    public Optional<Region> getRegion(Integer id){return repository.findById(id);}

    public Region saveRegion(Region region){return repository.save(region);}

    public void deleteRegion(Integer id){
        if (repository.existsById(id)){
            repository.deleteById(id);}
        else{
            throw new RuntimeException("No encontrado");
        }
    }
}
