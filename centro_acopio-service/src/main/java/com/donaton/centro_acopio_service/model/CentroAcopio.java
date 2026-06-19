package com.donaton.centro_acopio_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //Genera getters y setters
@AllArgsConstructor //Genera constructores con parametros para cada campo
@NoArgsConstructor //Genera constructor sin parametros
@Entity //Marca la clase como entidad JPA, para mapear BD
@Table(name = "centro_acopio") //Tabla especifica en BD
public class CentroAcopio {
    @Id //clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Ingresa valor automaticamente
    private Integer id;
    private String nombre, direccion,ciudad;
    private int capacidad;
}
