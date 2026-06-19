package com.donaton.donacion_service.controller;

import com.donaton.donacion_service.model.Donacion;
import com.donaton.donacion_service.model.TipoDonacion;
import com.donaton.donacion_service.service.TipoDonacionService;
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
@RequestMapping("/api/v1/tipodonacion")
@Tag(name = "Tipos de Donaciones", description = "Operaciones relacionadas con los Tipo de Donaciones")
public class TipoDonacionController {
    @Autowired
    private TipoDonacionService tipoDonacionService;

    @Operation(summary = "Obtiene todos los detalles de los Tipos de donaciones.")
    @GetMapping
    public ResponseEntity<List<TipoDonacion>> listarDonaciones() {
        List<TipoDonacion> tipo =tipoDonacionService.getTipoDonaciones();
        if(tipo.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(tipo);
        }
    }
    @Operation(summary = "Obtiene los datos de un tipo de donacion en base a su Id.")
    @GetMapping("/{id}")
    public EntityModel<TipoDonacion> buscarPorId(@PathVariable Integer id) {
        TipoDonacion tipoDonacion = tipoDonacionService.getTipoDonacion(id)
                .orElseThrow(() -> new RuntimeException("Tipo de donación no encontrado"));

        EntityModel<TipoDonacion> model = EntityModel.of(tipoDonacion);

        // Self link
        model.add(
                linkTo(
                        methodOn(TipoDonacionController.class).buscarPorId(id)
                ).withSelfRel()
        );

        // Link directo (estilo del ejemplo)
        model.add(
                Link.of("http://localhost:8080/api/v1/tipos-donacion/" + id, "buscar por id")
        );

        // Link para listar todos
        model.add(
                linkTo(
                        methodOn(TipoDonacionController.class).listarDonaciones()
                ).withRel("Todos los tipos de donación")
        );

        return model;
    }
    @Operation(summary = "Guarda un nuevo tipo de donacion.")
    @PostMapping
    public ResponseEntity<TipoDonacion> agregarTipoDonacion(@RequestBody TipoDonacion tipo){
        TipoDonacion newTipo= tipoDonacionService.saveTipoDonacion(tipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTipo);
    }
    @Operation(summary = "Actualiza un tipo de donacion en base a su Id. ")
    @PutMapping("/{id}")
    public ResponseEntity<TipoDonacion> actualizarTipoDonacion(@PathVariable Integer id, @RequestBody TipoDonacion tipo){
        Optional<TipoDonacion> existe=tipoDonacionService.getTipoDonacion(id);
        if(existe.isEmpty()){return ResponseEntity.notFound().build();}
        tipo.setId(id);
        TipoDonacion actualizado=tipoDonacionService.saveTipoDonacion(tipo);
        return ResponseEntity.ok(actualizado);
    }
    @Operation(summary = "ELimina un tipo de donacion en base a su Id.")
    @DeleteMapping("{id}")
    public ResponseEntity<TipoDonacion> eliminarTipoDonacion(@PathVariable Integer id){
    try{
        tipoDonacionService.deleteTipoDonacion(id);
        return ResponseEntity.ok().build();
    }catch(Exception e){
        return ResponseEntity.notFound().build();
    }

    }
}
