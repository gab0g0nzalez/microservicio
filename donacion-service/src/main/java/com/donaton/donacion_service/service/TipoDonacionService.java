package com.donaton.donacion_service.service;

import com.donaton.donacion_service.model.TipoDonacion;
import com.donaton.donacion_service.repository.TipoDonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDonacionService {
    @Autowired
    private TipoDonacionRepository tipoDonacionRepository;

    public List<TipoDonacion> getTipoDonaciones(){return tipoDonacionRepository.findAll();}
    public Optional<TipoDonacion> getTipoDonacion(Integer id){return tipoDonacionRepository.findById(id);}
    public TipoDonacion saveTipoDonacion(TipoDonacion tipoDonacion){return tipoDonacionRepository.save(tipoDonacion);}
    public void deleteTipoDonacion(Integer id){
        if(tipoDonacionRepository.existsById(id)){
        tipoDonacionRepository.deleteById(id);
        }else{
           throw new RuntimeException("No encontrado!");
        }
    }
}
