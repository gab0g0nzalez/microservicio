package com.donaton.usuarios_service.repository;

import com.donaton.usuarios_service.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,Integer> {
}
