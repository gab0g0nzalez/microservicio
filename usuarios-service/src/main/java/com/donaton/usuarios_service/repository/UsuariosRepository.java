package com.donaton.usuarios_service.repository;

import com.donaton.usuarios_service.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios,Integer> {
}
