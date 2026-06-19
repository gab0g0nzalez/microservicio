package com.donaton.usuarios_service.service;

import com.donaton.usuarios_service.model.Usuarios;
import com.donaton.usuarios_service.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepository repository;

    public List<Usuarios> getUsuarios(){
        return repository.findAll();
    }

    public Optional<Usuarios> getUsuarioById(Integer id){
        return repository.findById(id);
    }

    public Usuarios saveUsuario(Usuarios usuarios){
        return repository.save(usuarios);
    }

    public Usuarios updateUsuario(Integer id, Usuarios usuarios){
        Optional existe = getUsuarioById(id);

        if(existe.isEmpty())
            throw new RuntimeException("NO encontrado");
        else
            return repository.save(usuarios);
    }

    public void delete(Integer id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }else{throw new RuntimeException("No encontrado");}

    }
}
