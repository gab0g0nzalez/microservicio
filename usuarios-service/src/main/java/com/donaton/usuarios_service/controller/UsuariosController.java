package com.donaton.usuarios_service.controller;

import com.donaton.usuarios_service.model.Usuarios;
import com.donaton.usuarios_service.service.UsuariosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuarios")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con los usuarios. ")

public class UsuariosController {

    @Autowired
    private UsuariosService service;

    @Operation(summary = "Obtiene todos los detalles de los usuarios.")
    @GetMapping
    public List<Usuarios> getUsuarios() {return service.getUsuarios();}

    @Operation(summary = "Obtiene los datos de un usuario en base a su Id.")
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> buscarPorId(@PathVariable Integer id) {
        Optional<Usuarios> usuario = service.getUsuarioById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Guarda un nuevo usuario.")
    @PostMapping
    public ResponseEntity<Usuarios> agregarUsuarios(@RequestBody Usuarios usuario) {
        Usuarios newUser = service.saveUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @Operation(summary = "Actualiza un usuario en base a su Id. ")
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuarios usuario) {
        Optional<Usuarios> existe= service.getUsuarioById(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);
        Usuarios actualizado= service.saveUsuario(usuario);
        return ResponseEntity.ok(actualizado);
    }

    @Operation(summary = "ELimina un usuario en base a su Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuarios> eliminarUsuario(@PathVariable Integer id){
        try{
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
