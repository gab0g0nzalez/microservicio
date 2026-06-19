package com.donaton.emergencias_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="emergencias")
public class Emergencia {
    enum ESTADO{
        REPORTADA,EN_PROCESO,RECHAZADA,FINALIZADA
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private LocalDate fecha_inicio;
    @Enumerated(EnumType.STRING)
    private ESTADO estado;
    private String ubicacion;
    private int comuna;

}
