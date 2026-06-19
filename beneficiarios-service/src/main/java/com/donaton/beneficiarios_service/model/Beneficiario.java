package com.donaton.beneficiarios_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="beneficiarios")
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_beneficiario")
    private Integer id;
    private String nombre;
    private String rut;
    private String telefono;
    @ManyToOne
    @JoinColumn(name = "id_comuna")
    private Comuna comuna;
}
