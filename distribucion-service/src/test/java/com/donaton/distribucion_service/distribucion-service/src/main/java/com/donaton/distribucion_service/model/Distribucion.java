package com.donaton.distribucion_service.distribucion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "distribucion")
public class Distribucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate fecha_entrega;
    private int cantidad_entregada;
    private int id_emergencia;
    private int id_beneficiario;
    private int id_donacion;
}
