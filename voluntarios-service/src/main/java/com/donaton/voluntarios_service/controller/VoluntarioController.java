package com.donaton.voluntarios_service.controller;

import com.donaton.voluntarios_service.model.Voluntario;
import com.donaton.voluntarios_service.service.VoluntarioService;
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
@RequestMapping("/api/v1/voluntarios")
@Tag(name = "Voluntarios", description = "Operaciones relacionadas con los voluntarios. ")
public class VoluntarioController {
    @Autowired
    private VoluntarioService service;

    @Operation(summary = "Obtiene todos los detalles de los voluntarios.")
    @GetMapping
    public ResponseEntity<List<Voluntario>> listarVoluntarios() {
        List<Voluntario> voluntarios = service.getVoluntarios();
        if (voluntarios.isEmpty()){
            return ResponseEntity.noContent().build();}
        else return ResponseEntity.ok(voluntarios);
    }

    @Operation(summary = "Obtiene los datos de un voluntario en base a su Id.")
    @GetMapping("/{id}")
    public EntityModel<Voluntario> buscarPorId(@PathVariable Integer id) {
        Voluntario voluntario = service.getVoluntario(id)
                .orElseThrow(() -> new RuntimeException("Voluntario no encontrado"));

        EntityModel<Voluntario> model = EntityModel.of(voluntario);

        // Self link
        model.add(
                linkTo(
                        methodOn(VoluntarioController.class).buscarPorId(id)
                ).withSelfRel()
        );

        // Link directo (estilo del ejemplo)
        model.add(
                Link.of("http://localhost:8090/api/v1/voluntarios/" + id, "buscar por id")
        );

        // Link para listar todos
        model.add(
                linkTo(
                        methodOn(VoluntarioController.class).listarVoluntarios()
                ).withRel("Todos los voluntarios")
        );

        return model;
    }

    @Operation(summary = "Guarda un nuevo voluntario.")
    @PostMapping
    public ResponseEntity<Voluntario> agregarVoluntario(@RequestBody Voluntario voluntario) {
        Voluntario newVoluntario = service.saveVoluntarios(voluntario);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVoluntario);
    }

    @Operation(summary = "Actualiza un voluntario en base a su Id. ")
    @PutMapping("/{id}")
    public ResponseEntity<Voluntario> editar(
            @PathVariable Integer id,
            @RequestBody Voluntario voluntarios
            ){
        Optional<Voluntario> existe = service.getVoluntario(id);

        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();

        }
        voluntarios.setId(id);
        Voluntario actualizado= service.saveVoluntarios(voluntarios);
        return ResponseEntity.ok(actualizado);
    }

    @Operation(summary = "ELimina un voluntario en base a su Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Voluntario> eliminar(@PathVariable Integer id) {
        try{
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
}
