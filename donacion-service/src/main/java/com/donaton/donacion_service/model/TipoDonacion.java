package com.donaton.donacion_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="tipo_donacion")
public class TipoDonacion {
    enum TIPO{
        ROPA, ALIMENTO, INSUMOS_MEDICOS, HIGIENE, OTRO
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Integer id;
    @Enumerated(EnumType.STRING)
    private TIPO nombre_tipo;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoDonacion", cascade = CascadeType.ALL)
    private List<Donacion> donaciones;
}
