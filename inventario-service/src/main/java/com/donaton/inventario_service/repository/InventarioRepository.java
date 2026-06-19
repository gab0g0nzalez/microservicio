package com.donaton.inventario_service.repository;

import com.donaton.inventario_service.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario,Integer> {
}
