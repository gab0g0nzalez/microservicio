package com.donaton.usuarios_service.service;

import com.donaton.usuarios_service.model.Roles;
import com.donaton.usuarios_service.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    private RolesRepository repository;

    public List<Roles> getRoles(){
        return repository.findAll();
    }

    public Optional<Roles> getRolById(Integer id){
        return repository.findById(id);
    }

    public Roles saveRol(Roles roles){
        return repository.save(roles);
    }

    public Roles updateRol(Integer id, Roles roles){
        Optional existe = getRolById(id);

        if(existe.isEmpty())
            throw new RuntimeException("NO encontrado");
        else
            return repository.save(roles);
    }

    public void delete(Integer id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }else{throw new RuntimeException("No encontrado");}

    }

}
