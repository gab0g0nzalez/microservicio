package com.donaton.auditoria_service.controller;

import com.donaton.auditoria_service.dto.AuditoriaUsuarioDTO;
import com.donaton.auditoria_service.model.Auditoria;
import com.donaton.auditoria_service.service.AuditoriaService;
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
@RequestMapping("/api/v1/auditoria")
@Tag(name = "Auditorías", description = "Operaciones relacionadas con las auditorias")
public class AuditoriaController {
@Autowired
    private AuditoriaService service;


    @Operation(summary = "Obtiene todos los detalles de las auditorías.")
    @GetMapping
    public ResponseEntity<List<Auditoria>> listarNuevo() {
        List<Auditoria> auditorias = service.getAuditoria();
        if (auditorias.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(auditorias);
    }

    @Operation(summary = "Obtiene los datos de una auditoría en base a su Id.")
    @GetMapping("/{id}")
    public EntityModel<Auditoria> buscarPorId(@PathVariable Integer id) {
        Auditoria auditoria = service.getAuditoria(id).orElseThrow();
        EntityModel<Auditoria> model = EntityModel.of(auditoria);

        model.add(
                linkTo(
                        methodOn(AuditoriaController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                Link.of("http://localhost:8081" +
                        "/api/v1/auditoria/" + id, "buscar por id")
        );

        model.add(
                linkTo(
                        methodOn(AuditoriaController.class)
                                .listarNuevo()
                ).withRel("Todas las Auditorias")
        );

        return model;

    }

    @Operation(summary = "Guarda una nueva auditoría.")
    @PostMapping
    public ResponseEntity<Auditoria> agregarEmergencia(@RequestBody Auditoria auditoria) {

        Auditoria nuevaAuditoria = service.saveAuditoria(auditoria);

        return ResponseEntity
                .status(HttpStatus.CREATED) //201 - Created
                .body(nuevaAuditoria);
    }

    @Operation(summary = "Actualiza una auditoría en base a su Id. ")
    @PutMapping("/{id}")
    public ResponseEntity<Auditoria> editar(
            @PathVariable Integer id,
            @RequestBody Auditoria auditoria
    ) {

        Optional<Auditoria> existe = service.getAuditoria(id);

        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        auditoria.setId(id);


        Auditoria actualizado = service.saveAuditoria(auditoria);
        return ResponseEntity.ok(actualizado); //201
    }

    @Operation(summary = "ELimina una auditoría en base a su Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        try{
            service.delete(id);
            return  ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    ///////////////usuario
    @Operation(summary = "Obtiene un Usuario en base a su auditoría.")
    @GetMapping("/usuarios/{id_auditoria}/{id_usuario}")
    public ResponseEntity<AuditoriaUsuarioDTO> getUsuario(@PathVariable Integer id_auditoria, @PathVariable Integer id_usuario){
        Optional<AuditoriaUsuarioDTO> dtos= service.getUsuario(id_auditoria,id_usuario);
        if (dtos.isPresent()){
            return ResponseEntity.ok(dtos.get());
        }else {
            return ResponseEntity.noContent().build();
        }
    }
}