package com.donaton.distribucion_service.service;

import com.donaton.distribucion_service.client.BeneficiarioClient;
import com.donaton.distribucion_service.dto.BeneficiarioDTO;
import com.donaton.distribucion_service.dto.DistribucionBeneficiarioDTO;
import com.donaton.distribucion_service.model.Distribucion;
import com.donaton.distribucion_service.repository.DistribucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistribucionService {
    @Autowired
    private DistribucionRepository repository;

    public List<Distribucion> getDistribucion(){
        return  repository.findAll();

    }
    public Optional<Distribucion> getDistribucion(Integer id){
        return repository.findById(id);
    }

    public  Distribucion saveDistribucion(Distribucion distribuciones){
        return  repository.save(distribuciones);
    }

    public Distribucion updateDistribucion(Integer id, Distribucion distribuciones) {
        Optional existe = getDistribucion(id);

        if(existe.isEmpty())
            throw new RuntimeException("NO encontrado");
        else
            return repository.save(distribuciones);
    }
    public void delete(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw  new RuntimeException("No encontrado");

    }

    @Autowired
    private BeneficiarioClient client;

    public Optional<DistribucionBeneficiarioDTO> getBeneficiario(Integer id_distribucion,Integer id_beneficiario) {
        BeneficiarioDTO beneficiario= client.getBeneficiarioDTO(id_beneficiario);
        Distribucion distribucion= repository.findById(id_distribucion).orElse(null);
        DistribucionBeneficiarioDTO dto= new DistribucionBeneficiarioDTO();

        dto.setId_distribucion(distribucion.getId());
        dto.setFecha_entrega(distribucion.getFecha_entrega());
        dto.setCantidad_entregada(distribucion.getCantidad_entregada());

        dto.setBeneficiario(beneficiario);

        return Optional.of(dto);
    }


}