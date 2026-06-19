package com.donaton.voluntarios_service.service;

import com.donaton.voluntarios_service.client.EmergenciaClient;
import com.donaton.voluntarios_service.dto.AsignacionEmergenciasDTO;
import com.donaton.voluntarios_service.dto.EmergenciasDTO;
import com.donaton.voluntarios_service.model.AsignacionesVoluntarios;
import com.donaton.voluntarios_service.repository.AsignacionesVoluntariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AsignacionesVoluntariosService {
    @Autowired
    private AsignacionesVoluntariosRepository repository;
    @Autowired
    private EmergenciaClient emergenciaClient;

    public List<AsignacionesVoluntarios> getAsignacionesVoluntarios(){
        return repository.findAll();
    }

    public Optional<AsignacionesVoluntarios> getAsignacionVoluntario(Integer id) {return repository.findById(id);}

    public AsignacionesVoluntarios saveAsignacionesVoluntarios(AsignacionesVoluntarios asignacionesVoluntarios ) { return repository.save(asignacionesVoluntarios);}

    public void delete(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);}
        else{
            throw new RuntimeException("No encontrado");}
    }

    public Optional<AsignacionEmergenciasDTO> getByIdEmergencia(Integer id_asignacion,Integer id_emergencia){
        EmergenciasDTO emergencia = emergenciaClient.getEmergenciasDTO(id_emergencia);
        AsignacionesVoluntarios asignacion = repository.findById(id_asignacion).orElse(null);
        AsignacionEmergenciasDTO dto  = new AsignacionEmergenciasDTO();

        dto.setId(asignacion.getId());
        dto.setTarea(asignacion.getTarea());
        dto.setId_emergencia(asignacion.getId_emergencia());


        dto.setEmergencias(emergencia);

        return Optional.of(dto);
    }

}
