package com.donaton.beneficiarios_service.controller;

import com.donaton.beneficiarios_service.model.Beneficiario;
import com.donaton.beneficiarios_service.service.BeneficiarioService;
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
@RequestMapping("/api/v1/beneficiarios")
@Tag(name = "Beneficiarios",description = "Operaciones relacionadas con los Beneficiarios")
public class BeneficiarioController {
    @Autowired
    private BeneficiarioService service;


    @GetMapping
    @Operation(summary = "Mustra la lista actual de Beneficiarios.")
    public ResponseEntity<List<Beneficiario>> listarNuevo() {
        List<Beneficiario> beneficiarios = service.getBeneficiarios();
        if (beneficiarios.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(beneficiarios);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene los datos de un Beneficiario en base a su Id.")
    public EntityModel<Beneficiario> buscarPorId(@PathVariable Integer id) {
        Beneficiario beneficiario = service.getBeneficiario(id)
                .orElseThrow(() -> new RuntimeException("Beneficiario no encontrado"));

        EntityModel<Beneficiario> model = EntityModel.of(beneficiario);

        // Self link
        model.add(
                linkTo(
                        methodOn(BeneficiarioController.class).buscarPorId(id)
                ).withSelfRel()
        );

        // Link directo (estilo del ejemplo)
        model.add(
                Link.of("http://localhost:8091/api/v1/beneficiarios/" + id, "buscar por id")
        );

        // Link para listar todos
        model.add(
                linkTo(
                        methodOn(BeneficiarioController.class).listarNuevo()
                ).withRel("Todos los beneficiarios")
        );

        return model;
    }


    @PostMapping
    @Operation(summary = "Agrega un Beneficiario dentro de la lista de Beneficiarios ")
    public ResponseEntity<Beneficiario> agregarBenerficiario(@RequestBody Beneficiario beneficiario) {

        Beneficiario nuevoBeneficiario = service.saveBeneficiario(beneficiario);

        return ResponseEntity
                .status(HttpStatus.CREATED) //201 - Created
                .body(nuevoBeneficiario);


    }

    @PutMapping("/{id}")
    @Operation(summary = "Funcion para editar entidades dentro de la lista de los Beneficiarios.")
    public ResponseEntity<Beneficiario> editar(
            @PathVariable Integer id,
            @RequestBody Beneficiario beneficiario
    ) {

        Optional<Beneficiario> existe = service.getBeneficiario(id);

        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        beneficiario.setId(id);


        Beneficiario actualizado = service.saveBeneficiario(beneficiario);
        return ResponseEntity.ok(actualizado); //201
    }
    @DeleteMapping("/id")
    @Operation(summary = "Elimina los Beneficiarios en base a su Id.")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        try{
            service.delete(id);
            return  ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }


    }
}
