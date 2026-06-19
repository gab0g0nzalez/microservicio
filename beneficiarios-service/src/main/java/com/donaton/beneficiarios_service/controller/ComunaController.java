package com.donaton.beneficiarios_service.controller;

import com.donaton.beneficiarios_service.model.Comuna;
import com.donaton.beneficiarios_service.service.ComunaService;
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
@RequestMapping("/api/v1/comunas")
@Tag(name = "Comuna",description = "Operaciones relacionadas con las Comunas")
public class ComunaController {
    @Autowired
    private ComunaService service;

    @GetMapping
    @Operation(summary = "Obtiene las Comunas dentro de la lista Comunas.")
    public ResponseEntity<List<Comuna>> listarComunas(){
        List<Comuna> comuna=service.getComunas();
        if(comuna.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(comuna);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene las Comunas por su ID.")
    public EntityModel<Comuna> buscarPorId(@PathVariable Integer id) {
        Comuna comuna = service.getComuna(id)
                .orElseThrow(() -> new RuntimeException("Comuna no encontrada"));

        EntityModel<Comuna> model = EntityModel.of(comuna);

        // Self link
        model.add(
                linkTo(
                        methodOn(ComunaController.class).buscarPorId(id)
                ).withSelfRel()
        );

        // Link directo (estilo del ejemplo)
        model.add(
                Link.of("http://localhost:8080/api/v1/comunas/" + id, "buscar por id")
        );

        // Link para listar todas
        model.add(
                linkTo(
                        methodOn(ComunaController.class).listarComunas()
                ).withRel("Todas las comunas")
        );

        return model;
    }

    @PostMapping
    @Operation(summary = "Funcion para Agregar Comunas dentro de la Lista.")
    public ResponseEntity<Comuna> agregarComuna(@RequestBody Comuna comuna){
        Comuna newComuna= service.saveComuna(comuna);
        return ResponseEntity.status(HttpStatus.CREATED).body(newComuna);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Permite editar algun parametro dentro de la lista de Comunas.")
    public ResponseEntity<Comuna> actualizarComuna(@PathVariable Integer id, @RequestBody Comuna comuna){
        Optional<Comuna> existe = service.getComuna(id);
        if(existe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        comuna.setId(id);
        Comuna actualizado=service.saveComuna(comuna);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina Comunas mediante el Id.")
    public ResponseEntity<Comuna> eliminarComuna(@PathVariable Integer id){
        try{
            service.deleteComuna(id);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
