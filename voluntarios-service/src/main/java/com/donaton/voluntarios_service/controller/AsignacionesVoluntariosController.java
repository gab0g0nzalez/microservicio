package com.donaton.voluntarios_service.controller;


import com.donaton.voluntarios_service.dto.AsignacionEmergenciasDTO;
import com.donaton.voluntarios_service.model.AsignacionesVoluntarios;
import com.donaton.voluntarios_service.service.AsignacionesVoluntariosService;
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
@RequestMapping("/api/v1/asignaciones")
@Tag(name = "Asignaciones de Voluntarios", description = "Operaciones relacionadas con los asignaciones de voluntarios. ")
public class AsignacionesVoluntariosController {
    @Autowired
    private AsignacionesVoluntariosService service;

    @Operation(summary = "Obtiene todos los detalles de las asignaciones.")
    @GetMapping
    public ResponseEntity<List<AsignacionesVoluntarios>> listarAsignaciones() {
        List<AsignacionesVoluntarios> asignaciones = service.getAsignacionesVoluntarios();
        if (asignaciones.isEmpty()){
            return ResponseEntity.noContent().build();}
        else return ResponseEntity.ok(asignaciones);
    }

    @Operation(summary = "Obtiene los datos de una asignacion en base a su Id.")
    @GetMapping("/{id}")
    public EntityModel<AsignacionesVoluntarios> buscarPorId(@PathVariable Integer id) {
        AsignacionesVoluntarios asignacion = service.getAsignacionVoluntario(id)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada"));

        EntityModel<AsignacionesVoluntarios> model = EntityModel.of(asignacion);

        // Self link
        model.add(
                linkTo(
                        methodOn(AsignacionesVoluntariosController.class).buscarPorId(id)
                ).withSelfRel()
        );

        // Link directo (estilo del ejemplo)
        model.add(
                Link.of("http://localhost:8090/api/v1/asignaciones-voluntarios/" + id, "buscar por id")
        );

        // Link para listar todas
        model.add(
                linkTo(
                        methodOn(AsignacionesVoluntariosController.class).listarAsignaciones()
                ).withRel("Todas las asignaciones")
        );

        return model;
    }

    @Operation(summary = "Guarda una nueva asignacion.")
    @PostMapping
    public ResponseEntity<AsignacionesVoluntarios> agregarAsignacion(@RequestBody AsignacionesVoluntarios asignacionesVoluntarios) {
        AsignacionesVoluntarios newAsign = service.saveAsignacionesVoluntarios(asignacionesVoluntarios);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAsign);
    }

    @Operation(summary = "Actualiza una asignacion en base a su Id. ")
    @PutMapping("/{id}")
    public ResponseEntity<AsignacionesVoluntarios> editar(
            @PathVariable Integer id,
            @RequestBody AsignacionesVoluntarios asignaciones
    ){
        Optional<AsignacionesVoluntarios> existe = service.getAsignacionVoluntario(id);

        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();

        }
        asignaciones.setId(id);
        AsignacionesVoluntarios actualizado= service.saveAsignacionesVoluntarios(asignaciones);
        return ResponseEntity.ok(actualizado);
    }

    @Operation(summary = "ELimina una asignacion en base a su Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<AsignacionesVoluntarios> eliminar(@PathVariable Integer id) {
        try{
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    /////////emergencias

    @Operation(summary = "Obtiene un Emergencia en base a su asignacion.")
    @GetMapping("/emergencias/{id_asignacion}/{id_emergencia}")
    public ResponseEntity<AsignacionEmergenciasDTO> listarEmergencia(@PathVariable Integer id_asignacion, @PathVariable Integer id_emergencia){
        Optional<AsignacionEmergenciasDTO> dtos= service.getByIdEmergencia(id_asignacion,id_emergencia);
        if(dtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(dtos.get());
        }
    }
}
