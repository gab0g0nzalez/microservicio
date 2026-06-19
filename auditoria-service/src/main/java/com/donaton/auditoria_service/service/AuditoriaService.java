package com.donaton.auditoria_service.service;

import com.donaton.auditoria_service.client.UsuariosClient;
import com.donaton.auditoria_service.dto.AuditoriaUsuarioDTO;
import com.donaton.auditoria_service.dto.UsuariosDTO;
import com.donaton.auditoria_service.model.Auditoria;
import com.donaton.auditoria_service.repository.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditoriaService {
    @Autowired
    private AuditoriaRepository repository;


    public List<Auditoria> getAuditoria() {
        return repository.findAll();

    }

    public Optional<Auditoria> getAuditoria(Integer id) {
        return repository.findById(id);
    }

    public Auditoria saveAuditoria(Auditoria auditoria) {
        return repository.save(auditoria);
    }

    public Auditoria updateAuditoria(Auditoria auditoria) {
        return repository.save(auditoria);
    }

    public void delete(Integer id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new RuntimeException("No encontrado");
    }
////////////////usuario
    @Autowired
    private UsuariosClient client;
    

    public Optional<AuditoriaUsuarioDTO> getUsuario(Integer id_donacion, Integer id_usuario){
        UsuariosDTO usuario = client.getUsuariosDTO(id_usuario);
        Auditoria auditoria= repository.findById(id_donacion).orElse(null);
        AuditoriaUsuarioDTO dto  = new AuditoriaUsuarioDTO();

        dto.setId(auditoria.getId());
        dto.setAccion(auditoria.getAccion());
        dto.setDescripcion(auditoria.getDescripcion());
        dto.setFecha_hora(auditoria.getFecha_hora());

        dto.setUsuarioDto(usuario);

        return Optional.of(dto);
    }
}
