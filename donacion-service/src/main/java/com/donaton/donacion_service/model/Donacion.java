package com.donaton.donacion_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="donacion")
public class Donacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_donacion")
    private Integer id;
    private String descripcion;
    private int cantidad;
    private LocalDate fecha_donacion;
    private Boolean estado=true;
    private int id_usuario;
    private int id_centro;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoDonacion tipoDonacion;

}
