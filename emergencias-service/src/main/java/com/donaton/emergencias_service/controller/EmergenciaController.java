package com.donaton.emergencias_service.controller;

import com.donaton.emergencias_service.dto.EmergenciaComunaDTO;
import com.donaton.emergencias_service.model.Emergencia;
import com.donaton.emergencias_service.service.EmergenciaService;
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
@RequestMapping("/api/v1/emergencias")
@Tag(name = "Emergencias",description = "Operaciones relacionadas con las Emergencias")
public class EmergenciaController {
    @Autowired
    private EmergenciaService service;

    @GetMapping
    @Operation(summary = "Permite ver las emergencias dentro dfe la lista")
    public ResponseEntity<List<Emergencia>> listarNuevo() {
        List<Emergencia> emergencias = service.getEmergencia();
        if (emergencias.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(emergencias);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Permite ver las Emergencias mediante el Id")
    public EntityModel<Emergencia> buscarPorId(@PathVariable Integer id) {
        Emergencia emergencia = service.getEmergencia(id)
                .orElseThrow(() -> new RuntimeException("Emergencia no encontrada"));

        EntityModel<Emergencia> model = EntityModel.of(emergencia);

        // Self link
        model.add(
                linkTo(
                        methodOn(EmergenciaController.class).buscarPorId(id)
                ).withSelfRel()
        );

        // Link directo (estilo del ejemplo)
        model.add(
                Link.of("http://localhost:8086/api/v1/emergencias/" + id, "buscar por id")
        );

        // Link para listar todas
        model.add(
                linkTo(
                        methodOn(EmergenciaController.class).listarNuevo()
                ).withRel("Todas las emergencias")
        );


        return model;
    }

    @PostMapping
    @Operation(summary = "Permite Agregar emergencias a la lista.")
    public ResponseEntity<Emergencia> agregarEmergencia(@RequestBody Emergencia emergencia) {

        Emergencia nuevaEmergencia = service.saveEmergencia(emergencia);

        return ResponseEntity
                .status(HttpStatus.CREATED) //201 - Created
                .body(nuevaEmergencia);


    }

    @PutMapping("/{id}")
    @Operation(summary = "Permite Editar las emergencias d la lista.")
    public ResponseEntity<Emergencia> editar(
            @PathVariable Integer id,
            @RequestBody Emergencia emergencia
    ) {

        Optional<Emergencia> existe = service.getEmergencia(id);

        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        emergencia.setId(id);


        Emergencia actualizado = service.saveEmergencia(emergencia);
        return ResponseEntity.ok(actualizado); //201
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Permite Borrar Emergencias dentro de la lista.")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        try{
            service.delete(id);
            return  ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    //////////comuna
    @GetMapping("/comunas/{id_emergencia}/{id_comuna}")
    @Operation(summary = "Permite visualizar las emergencias de cada comuna.")
    public ResponseEntity<EmergenciaComunaDTO> obtenerEmergenciaComuna(@PathVariable Integer id_emergencia, @PathVariable Integer id_comuna) {
        Optional<EmergenciaComunaDTO> dtos= service.getEmergenciaComuna(id_emergencia, id_comuna);
        if (dtos.isPresent()){
            return ResponseEntity.ok(dtos.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }
}

