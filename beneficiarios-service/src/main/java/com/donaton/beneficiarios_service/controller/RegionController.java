package com.donaton.beneficiarios_service.controller;


import com.donaton.beneficiarios_service.model.Region;
import com.donaton.beneficiarios_service.service.RegionService;
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
@RequestMapping("/api/v1/regiones")
@Tag(name = "Region",description = "Operaciones relacionadas con las Regiones")
public class RegionController {
    @Autowired
    private RegionService service;

    @GetMapping
    @Operation(summary = "Obtiene las Regiones dentro de la Lista.")
    public ResponseEntity<List<Region>> listarRegiones(){
        List<Region> regiones =service.getRegiones();
        if(regiones.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(regiones);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene Una region en especifico mediante su Id.")
    public EntityModel<Region> buscarPorId(@PathVariable Integer id) {
        Region region = service.getRegion(id)
                .orElseThrow(() -> new RuntimeException("Región no encontrada"));

        EntityModel<Region> model = EntityModel.of(region);

        // Self link
        model.add(
                linkTo(
                        methodOn(RegionController.class).buscarPorId(id)
                ).withSelfRel()
        );

        // Link directo (estilo del ejemplo)
        model.add(
                Link.of("http://localhost:8080/api/v1/regiones/" + id, "buscar por id")
        );

        // Link para listar todas
        model.add(
                linkTo(
                        methodOn(RegionController.class).listarRegiones()
                ).withRel("Todas las regiones")
        );

        return model;
    }

    @PostMapping
    @Operation(summary = "Agrega una Region a la Lista.")
    public ResponseEntity<Region> agregarRegion(@RequestBody Region region){
        Region newRegion = service.saveRegion(region);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRegion);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Funcion para editar aspectos de las Regiones dentro de la Lista.")
    public ResponseEntity<Region> actualizarRegion(@PathVariable Integer id, @RequestBody Region region){
        Optional<Region> existe = service.getRegion(id);
        if(existe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        region.setId(id);
        Region actualizado=service.saveRegion(region);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borra Regiones mediante el Id.")
    public ResponseEntity<Region> eliminarRegion(@PathVariable Integer id){
        try{
            service.deleteRegion(id);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
