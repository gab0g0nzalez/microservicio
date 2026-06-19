package com.donaton.transporte_service.service;

import com.donaton.transporte_service.model.Vehiculo;
import com.donaton.transporte_service.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository repository;
    public List<Vehiculo> getVehiculos(){return repository.findAll();}
    public Optional<Vehiculo> getVehiculo(Integer id){return repository.findById(id);}
    public Vehiculo saveVehiculo(Vehiculo vehiculo){return repository.save(vehiculo);}
    public void deleteVehiculo(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }else {
            throw new RuntimeException("No encontrado");
        }
    }
}
