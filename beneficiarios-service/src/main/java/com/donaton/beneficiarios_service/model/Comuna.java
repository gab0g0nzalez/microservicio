package com.donaton.beneficiarios_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "comuna")
public class Comuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comuna")
    private Integer id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_region")
    private Region region;

    @JsonIgnore
    @OneToMany(mappedBy = "comuna", cascade = CascadeType.ALL)
    private List<Beneficiario> beneficiarios;
}
