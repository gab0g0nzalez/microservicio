package com.donaton.transporte_service.controller;

import com.donaton.transporte_service.model.Vehiculo;
import com.donaton.transporte_service.service.VehiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vehiculos")
@Tag(name = "Vehiculos", description = "Operaciones relacionadas con los Vehiculos")
public class VehiculoController {
    @Autowired
    private VehiculoService service;

    @Operation(summary = "Obtiene todos los detalles de los Vehiculos.")
    @GetMapping
    public ResponseEntity<List<Vehiculo>> listarVehiculos() {
        List<Vehiculo> vehi = service.getVehiculos();
        if (vehi.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(vehi);
        }
    }
    @Operation(summary = "Obtiene los datos de un vehiculo en base a su Id.")
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> buscarPorId(@PathVariable Integer id) {
        Optional<Vehiculo> vehi = service.getVehiculo(id);
        if (vehi.isPresent()) {
            return ResponseEntity.ok(vehi.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Guarda un nuevo vehiculo.")
    @PostMapping
    public ResponseEntity<Vehiculo> agregarVehiculo(@RequestBody Vehiculo vehiculo){
        Vehiculo nuevo=service.saveVehiculo(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
    @Operation(summary = "Actualiza una vehiculo en base a su Id.")
    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizarVehiculo(@PathVariable Integer id, @RequestBody Vehiculo vehiculo){
        Optional<Vehiculo> existe= service.getVehiculo(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        vehiculo.setId(id);
        Vehiculo actualizado= service.saveVehiculo(vehiculo);
        return ResponseEntity.ok(actualizado);
    }
    @Operation(summary = "ELimina un vehiculo en base a su Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Vehiculo> eliminarVehiculo(@PathVariable Integer id){
        try{
            service.deleteVehiculo(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}