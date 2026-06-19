package com.donaton.centro_acopio_service.controller;

import com.donaton.centro_acopio_service.model.CentroAcopio;
import com.donaton.centro_acopio_service.service.CentroAcopioService;
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

@RestController //indica que esta clase devuelve JSON o XML
@RequestMapping("/api/v1/centros")
@Tag(name = "Centro de Acopio",description = "Operaciones relacionadas con los Centros de Acopio")
public class CentroAcopioController {
    @Autowired
    private CentroAcopioService service;

    @GetMapping
    @Operation(summary = "Obtiene los Centros de Acopio dentro de la lista.")
    public List<CentroAcopio> getCentroAcopio() {return service.getCentrosAcopio();}

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene los Centros de Acopio dentro de la lista mediante el ID.")
    public EntityModel<CentroAcopio> buscarPorId(@PathVariable Integer id) {
        CentroAcopio centroAcopio = service.getCentroAcopioById(id)
                .orElseThrow();

        EntityModel<CentroAcopio> model = EntityModel.of(centroAcopio);

        // Self link
        model.add(
                linkTo(
                        methodOn(CentroAcopioController.class).buscarPorId(id)
                ).withSelfRel()
        );

        // Link directo (estilo del ejemplo)
        model.add(
                Link.of("http://localhost:8080/api/v1/centros-acopio/" + id, "buscar por id")
        );

        // Link para listar todos
        model.add(
                linkTo(
                        methodOn(CentroAcopioController.class).getCentroAcopio()
                ).withRel("Todos los centros de acopio")
        );

        return model;
    }
    @PostMapping
    @Operation(summary = "Agrega buses a la lista de Centro de Acopio.")
    public ResponseEntity<CentroAcopio> agregarBus(@RequestBody CentroAcopio centroAcopio) {
        CentroAcopio newCent = service.saveCentroAcopio(centroAcopio);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCent);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Permite editar parametros dentro del Inventario de Centro de Acopio.")
    public ResponseEntity<CentroAcopio> actualizarInventario(@PathVariable Integer id, @RequestBody CentroAcopio centroAcopio) {
        Optional<CentroAcopio> existe= service.getCentroAcopioById(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        centroAcopio.setId(id);
        CentroAcopio actualizado= service.saveCentroAcopio(centroAcopio);
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Permite Borrar el Inventario dentro de Centro de Acopio.")
    public ResponseEntity<CentroAcopio> eliminarInventario(@PathVariable Integer id){
        try{
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
