package com.donaton.voluntarios_service.service;

import com.donaton.voluntarios_service.model.Voluntario;
import com.donaton.voluntarios_service.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VoluntarioService {
    @Autowired
    private VoluntarioRepository repository;

    public List<Voluntario> getVoluntarios(){
        return repository.findAll();
    }

    public Optional<Voluntario> getVoluntario(Integer id) {return repository.findById(id);}

    public Voluntario saveVoluntarios(Voluntario voluntarios) { return repository.save(voluntarios);}

    public Voluntario updatgeVoluntarios(Integer id, Voluntario voluntarios) {
        Optional<Voluntario> existe = getVoluntario(id);

        if (existe.isEmpty())
            throw new RuntimeException("NO encontrado");
        else
            return repository.save(voluntarios);
    }
    public void delete(Integer id){
        if(repository.existsById(id)){
        repository.deleteById(id);}
    else{
        throw new RuntimeException("No encontrado");}
    }

}
