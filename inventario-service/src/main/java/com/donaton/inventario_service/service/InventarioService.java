package com.donaton.inventario_service.service;

import com.donaton.inventario_service.client.DonacionClient;
import com.donaton.inventario_service.dto.DonacionDTO;
import com.donaton.inventario_service.dto.InventarioDonacionDTO;
import com.donaton.inventario_service.model.Inventario;
import com.donaton.inventario_service.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository repository;
    @Autowired
    private DonacionClient donacionClient;

    public List<Inventario> getAllInventario() {
        return repository.findAll();
    }

    public Optional<Inventario> getInventarioById(Integer id) {
        return repository.findById(id);
    }

    public Inventario saveInventario(Inventario inventario) {
        return repository.save(inventario);
    }

    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("No encontrado");
        }

    }

    /// /////////////////donacion
    public Optional<InventarioDonacionDTO> getDonaciones(Integer id_inventario, Integer id_donacion) {
        DonacionDTO donacion = donacionClient.getDonacionDTO(id_donacion);
        Inventario inventario = repository.findById(id_inventario).orElse(null);
        InventarioDonacionDTO dto = new InventarioDonacionDTO();

        dto.setId_inventario(inventario.getId());
        dto.setFecha_actualizacion(inventario.getFecha_actualizacion());
        dto.setStock_actual(inventario.getStock_actual());

        dto.setDonacion(donacion);

        return Optional.of(dto);
    }
}