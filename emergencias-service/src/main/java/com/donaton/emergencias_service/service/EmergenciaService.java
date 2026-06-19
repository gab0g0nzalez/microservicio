package com.donaton.emergencias_service.service;

import com.donaton.emergencias_service.client.ComunaClient;
import com.donaton.emergencias_service.dto.ComunaDTO;
import com.donaton.emergencias_service.dto.EmergenciaComunaDTO;
import com.donaton.emergencias_service.model.Emergencia;
import com.donaton.emergencias_service.repository.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmergenciaService {
    @Autowired
    private EmergenciaRepository repository;


    public List<Emergencia> getEmergencia() {
        return repository.findAll();

    }

    public Optional<Emergencia> getEmergencia(Integer id) {
        return repository.findById(id);
    }

    public Emergencia saveEmergencia(Emergencia emergencia) {
        return repository.save(emergencia);
    }

    public Emergencia updateEmergencia(Emergencia emergencia) {
        return repository.save(emergencia);
    }

    public void delete(Integer id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new RuntimeException("No encontrado");
    }
    /////////////comunas
    @Autowired
    private ComunaClient client;
    public Optional<EmergenciaComunaDTO> getEmergenciaComuna(Integer id_emergencia,Integer id_comuna) {
        ComunaDTO comunaDTO = client.getComuna(id_comuna);
        Emergencia emergencia = repository.findById(id_emergencia).orElse(null);
        EmergenciaComunaDTO dto  = new EmergenciaComunaDTO();

        dto.setId(emergencia.getId());
        dto.setDescripcion(emergencia.getDescripcion());
        dto.setFecha_inicio(emergencia.getFecha_inicio());
        dto.setUbicacion(emergencia.getUbicacion());

        dto.setComuna(comunaDTO);

        return Optional.of(dto);
    }
}
