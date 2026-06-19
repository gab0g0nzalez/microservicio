package com.donaton.distribucion_service.controller;

import com.donaton.distribucion_service.dto.DistribucionBeneficiarioDTO;
import com.donaton.distribucion_service.model.Distribucion;
import com.donaton.distribucion_service.service.DistribucionService;
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
@RequestMapping("api/v1/distribuciones")
@Tag(name = "Distribuciones",description = "Operaciones relacionadas con las Distribuciones")
public class DistribucionController {
    @Autowired
    private DistribucionService service;

    //@GetMapping
    public List<Distribucion> listar() {
        return service.getDistribucion();
    }

    @GetMapping
    @Operation(summary = "Permite ver la lista de las Distribuciones.")
    public ResponseEntity<List<Distribucion>> listarNuevo() {
        List<Distribucion> distribuciones = service.getDistribucion();
        if (distribuciones.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(distribuciones);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Permite Buscar Distribuciones mediante el Id")
    public EntityModel<Distribucion> buscarPorId(@PathVariable Integer id) {
        Distribucion distribucion = service.getDistribucion(id)
                .orElseThrow();

        EntityModel<Distribucion> model = EntityModel.of(distribucion);

        // Self link
        model.add(
                linkTo(
                        methodOn(DistribucionController.class).buscarPorId(id)
                ).withSelfRel()
        );

        // Link directo (estilo del ejemplo)
        model.add(
                Link.of("http://localhost:8084/api/v1/distribuciones/" + id, "buscar por id")
        );

        // Link para listar todas
        model.add(
                linkTo(
                        methodOn(DistribucionController.class).listarNuevo()
                ).withRel("Todas las distribuciones")
        );

        // Link para obtener distribución con beneficiario
        model.add(
                linkTo(
                        methodOn(DistribucionController.class).buscarPorId(id)
                ).withRel("Buscar por Id")
        );

        return model;
    }

    @PostMapping
    @Operation(summary = "Permite agregar distribuciones a la lista.")
    public ResponseEntity<Distribucion> agregarDistribucion(@RequestBody Distribucion distribuciones) {

        Distribucion nuevoDistribucion = service.saveDistribucion(distribuciones);

        return ResponseEntity
                .status(HttpStatus.CREATED) //201 - Created
                .body(nuevoDistribucion);


    }

    @PutMapping("/{id}")
    @Operation(summary = "Permite editar parametros dentro de la lista de Distribuciones.")
    public ResponseEntity<Distribucion> editar(
            @PathVariable Integer id,
            @RequestBody Distribucion distribuciones
    ) {

        Optional<Distribucion> existe = service.getDistribucion(id);

        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        distribuciones.setId(id);

        Distribucion actualizado = service.saveDistribucion(distribuciones);
        return ResponseEntity.ok(actualizado); //201
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Permite Borrar distribuciones dentro de la lista.")
    public ResponseEntity<Distribucion> eliminar(@PathVariable Integer id){
        try{
            service.delete(id);
            return  ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /////////////////
    @GetMapping("/beneficiarios/{id_distribucion}/{id_beneficiarios}")
    @Operation(summary = "Entrega el id de las distribuciones con las respectivas Ids de sus beneficiarios.")
    public ResponseEntity<DistribucionBeneficiarioDTO> listarDistribucionBeneficiario(@PathVariable Integer id_distribucion, @PathVariable Integer id_beneficiarios){
        Optional<DistribucionBeneficiarioDTO>dtos=service.getBeneficiario(id_distribucion,id_beneficiarios);
        if (dtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(dtos.get());
        }
    }

}
