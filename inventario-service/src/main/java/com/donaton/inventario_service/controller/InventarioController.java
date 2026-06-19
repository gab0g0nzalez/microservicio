package com.donaton.inventario_service.controller;

import com.donaton.inventario_service.dto.DonacionDTO;
import com.donaton.inventario_service.dto.InventarioDonacionDTO;
import com.donaton.inventario_service.model.Inventario;
import com.donaton.inventario_service.service.InventarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/inventarios")
@Tag(name = "Inventarios",description = "Operaciones relacionadas con los Inventarios")
public class InventarioController {
    @Autowired
    private InventarioService service;

    @Operation(summary = "Obtiene todos los detalles de los inventarios.")
    @GetMapping
    public ResponseEntity<List<Inventario>> listarInventarios(){
        List<Inventario> inventario = service.getAllInventario();
        if(inventario.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(inventario);
        }
    }
    @Operation(summary = "Obtiene los datos de un inventario en base a su Id.")
    @GetMapping("/{id}")
    public ResponseEntity<Inventario> buscarPorId(@PathVariable Integer id) {
        Optional<Inventario> inventario = service.getInventarioById(id);
        if (inventario.isPresent()) {
            return ResponseEntity.ok(inventario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Guarda un nuevo inventario.")
    @PostMapping
    public ResponseEntity<Inventario> agregarInventario(@RequestBody Inventario inventario){
        Inventario newInv = service.saveInventario(inventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(newInv);
    }
    @Operation(summary = "Actualiza un inventario en base a su Id. ")
    @PutMapping("/{id}")
    public ResponseEntity<Inventario> actualizarInventario(@PathVariable Integer id, @RequestBody Inventario inventario){
        Optional<Inventario> existe= service.getInventarioById(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        inventario.setId(id);
        Inventario actualizado= service.saveInventario(inventario);
        return ResponseEntity.ok(actualizado);
    }
    @Operation(summary = "ELimina un inventario en base a su Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Inventario> eliminarInventario(@PathVariable Integer id){
        try{
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    ////////////////////Donacion
    @Operation(summary = "Obtiene una Donacion en base a su inventario.")
    @GetMapping("/donaciones/{id_inventario}/{id_donacion}")
    public ResponseEntity<InventarioDonacionDTO> obtenerDonaciones(@PathVariable Integer id_inventario, @PathVariable Integer id_donacion){
        Optional<InventarioDonacionDTO> dtos=service.getDonaciones(id_inventario,id_donacion);
        if(dtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(dtos.get());
        }
    }
}
