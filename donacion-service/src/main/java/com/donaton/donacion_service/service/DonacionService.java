package com.donaton.donacion_service.service;

import com.donaton.donacion_service.client.UsuariosClient;
import com.donaton.donacion_service.dto.DonacionUsuariosDTO;
import com.donaton.donacion_service.dto.UsuariosDTO;
import com.donaton.donacion_service.model.Donacion;
import com.donaton.donacion_service.repository.DonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonacionService {
    @Autowired
    private DonacionRepository donacionRepository;
    @Autowired
    private UsuariosClient usuariosClient;

    public List<Donacion> getDonaciones() {return donacionRepository.findAll();}
    public Optional<Donacion> getDonacion(Integer id){return donacionRepository.findById(id);}
    public Donacion saveDonacion(Donacion donacion){return donacionRepository.save(donacion);}
    public void delete(Integer id){
        if(donacionRepository.existsById(id)) {
            donacionRepository.deleteById(id);
        }else{throw new RuntimeException("No encontrado");}

    }

    ////////////////////usuarios

    public Optional<DonacionUsuariosDTO> getUsuarios(Integer id_donacion,Integer id_usuario){
        UsuariosDTO usuario = usuariosClient.getUsuariosDTO(id_usuario);
        Donacion donacion = donacionRepository.findById(id_donacion).orElse(null);
        DonacionUsuariosDTO dto  = new DonacionUsuariosDTO();

        dto.setId(donacion.getId());
        dto.setDescripcion(donacion.getDescripcion());
        dto.setFecha_donacion(donacion.getFecha_donacion());

        dto.setUsuariosDTO(usuario);

        return Optional.of(dto);
    }

}

