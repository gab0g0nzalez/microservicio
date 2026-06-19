package com.donaton.voluntarios_service.controller;

import com.donaton.voluntarios_service.model.Voluntario;
import com.donaton.voluntarios_service.service.VoluntarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Voluntario> buscarPorId(@PathVariable Integer id) {
        Optional<Voluntario> voluntarios = service.getVoluntario(id);

        if (voluntarios.isPresent())
            return ResponseEntity.ok(voluntarios.get());
        else return ResponseEntity.notFound().build();
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
