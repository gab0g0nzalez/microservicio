package com.donaton.voluntarios_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asignaciones_voluntarios")
public class AsignacionesVoluntarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion")
    private Integer id;
    private int id_emergencia;
    private String tarea;

    @ManyToOne
    @JoinColumn(name = "id_voluntario")
    private Voluntario voluntario;
}
