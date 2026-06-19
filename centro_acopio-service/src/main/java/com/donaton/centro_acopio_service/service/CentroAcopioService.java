package com.donaton.centro_acopio_service.service;

import com.donaton.centro_acopio_service.model.CentroAcopio;
import com.donaton.centro_acopio_service.repository.CentroAcopioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    //clase tipo service (logica de negocio)
public class CentroAcopioService {
    @Autowired  //inyecta dependencia
    private CentroAcopioRepository repository;
    //lista los campos dentro de la BD, por medio de repo
    public List<CentroAcopio> getCentrosAcopio(){
        return repository.findAll();
    }
//consigue un unico campo mediante id
    public Optional<CentroAcopio> getCentroAcopioById(Integer id){
        return repository.findById(id);
    }
//guarda campo en BD
    public CentroAcopio saveCentroAcopio(CentroAcopio centroAcopio){
        return repository.save(centroAcopio);
    }

//eliminar campo en BD
    public void delete(Integer id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }else{throw new RuntimeException("No encontrado");}

    }

}
