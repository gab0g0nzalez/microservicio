package com.donaton.donacion_service.controller;

import com.donaton.donacion_service.dto.DonacionUsuariosDTO;
import com.donaton.donacion_service.model.Donacion;
import com.donaton.donacion_service.service.DonacionService;
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
@RequestMapping("/api/v1/donaciones")
@Tag(name = "Donaciones", description = "Operaciones relacionadas con las donaciones")
public class DonacionController {
    @Autowired
    private DonacionService donacionService;

    @Operation(summary = "Obtiene todos los detalles de las donaciones.")
    @GetMapping
    public ResponseEntity<List<Donacion>> listarDonaciones() {
        List<Donacion> donacion =donacionService.getDonaciones();
        if(donacion.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(donacion);
        }
    }

    @Operation(summary = "Obtiene los datos de una donacion en base a su Id.")
    @GetMapping("/{id}")
    public EntityModel<Donacion> buscarPorId(@PathVariable Integer id) {
        Donacion donacion = donacionService.getDonacion(id)
                .orElseThrow();

        EntityModel<Donacion> model = EntityModel.of(donacion);

        // Self link
        model.add(
                linkTo(
                        methodOn(DonacionController.class).buscarPorId(id)
                ).withSelfRel()
        );

        // Link directo (estilo del ejemplo)
        model.add(
                Link.of("http://localhost:8080/api/v1/donaciones/" + id, "buscar por id")
        );

        // Link para listar todas
        model.add(
                linkTo(
                        methodOn(DonacionController.class).listarDonaciones()
                ).withRel("Todas las donaciones")
        );

        // Link para obtener donación con usuario
        model.add(
                linkTo(
                        methodOn(DonacionController.class).buscarPorId(id)
                ).withRel("donación con usuario")
        );

        return model;
    }


    @Operation(summary = "Guarda una nueva donacion.")
    @PostMapping
    public ResponseEntity<Donacion> agregarDonacion(@RequestBody Donacion donacion){
        Donacion newDonacion = donacionService.saveDonacion(donacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDonacion);
    }
    @Operation(summary = "Actualiza una donacion en base a su Id. ")
    @PutMapping("/{id}")
    public ResponseEntity<Donacion> actualizarDonacion(@PathVariable Integer id, @RequestBody Donacion donacion){
        Optional<Donacion> existe=donacionService.getDonacion(id);
        if(existe.isEmpty()){return ResponseEntity.notFound().build();}
        donacion.setId(id);
        Donacion actualizado=donacionService.saveDonacion(donacion);
        return ResponseEntity.ok(actualizado);
    }

    @Operation(summary = "ELimina una donacion en base a su Id.")
    @DeleteMapping("{id}")
    public ResponseEntity<Donacion> eliminarDonacion(@PathVariable Integer id){
        try{
            donacionService.delete(id);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }

    }


    //////////////////Usuarios
    @Operation(summary = "Obtiene un Usuario en base a su donacion.")
    @GetMapping("/usuarios/{id_donacion}/{id_usuario}")
    public ResponseEntity<DonacionUsuariosDTO> listarDonacionUsuario(@PathVariable Integer id_donacion,@PathVariable Integer id_usuario){
        Optional<DonacionUsuariosDTO> dtos= donacionService.getUsuarios(id_donacion,id_usuario);
        if(dtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(dtos.get());
        }
    }
}
