package com.donaton.usuarios_service.controller;

import com.donaton.usuarios_service.model.Roles;
import com.donaton.usuarios_service.service.RolesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/roles")
@Tag(name = "Roles", description = "Operaciones relacionadas con los roles. ")

public class RolesController {

    @Autowired
    private RolesService service;
    
    @Operation(summary = "Obtiene todos los detalles de los rols.")
    @GetMapping
    public List<Roles> getRoles() {return service.getRoles();}

    @Operation(summary = "Obtiene los datos de un rol en base a su Id.")
    @GetMapping("/{id}")
    public ResponseEntity<Roles> buscarPorId(@PathVariable Integer id) {
        Optional<Roles> rol = service.getRolById(id);
        if (rol.isPresent()) {
            return ResponseEntity.ok(rol.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Guarda un nuevo rol.")
    @PostMapping
    public ResponseEntity<Roles> agregarRol(@RequestBody Roles roles) {
        Roles newRol = service.saveRol(roles);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRol);
    }

    @Operation(summary = "Actualiza un rol en base a su Id. ")
    @PutMapping("/{id}")
    public ResponseEntity<Roles> actualizarRol(@PathVariable Integer id, @RequestBody Roles roles) {
        Optional<Roles> existe= service.getRolById(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        roles.setId(id);
        Roles actualizado= service.saveRol(roles);
        return ResponseEntity.ok(actualizado);
    }
    
    @Operation(summary = "ELimina un rol en base a su Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Roles> eliminarRol(@PathVariable Integer id){
        try{
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
