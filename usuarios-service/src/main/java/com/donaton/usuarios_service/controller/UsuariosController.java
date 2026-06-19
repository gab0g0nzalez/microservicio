package com.donaton.usuarios_service.controller;

import com.donaton.usuarios_service.model.Usuarios;
import com.donaton.usuarios_service.service.UsuariosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public EntityModel<Usuarios> buscarPorId(@PathVariable Integer id) {
        Usuarios usuario = service.getUsuarioById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        EntityModel<Usuarios> model = EntityModel.of(usuario);

        // Self link
        model.add(
                linkTo(
                        methodOn(UsuariosController.class).buscarPorId(id)
                ).withSelfRel()
        );

        // Link directo (estilo del ejemplo)
        model.add(
                Link.of("http://localhost:8089/api/v1/usuarios/" + id, "buscar por id")
        );

        // Link para listar todos
        model.add(
                linkTo(
                        methodOn(UsuariosController.class).getUsuarios()
                ).withRel("Todos los usuarios")
        );

        return model;
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
