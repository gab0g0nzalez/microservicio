package com.donaton.voluntarios_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "voluntarios")
public class Voluntario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voluntario")
    private Integer id;
    private LocalDate fecha_ingreso;
    private boolean disponibilidad =true;
    private int id_usuario;
    @JsonIgnore
    @OneToMany(mappedBy = "voluntario", cascade = CascadeType.ALL)
    private List<AsignacionesVoluntarios> asignacionesVoluntarios ;
}
