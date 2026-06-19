package com.donaton.beneficiarios_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="region")
public class Region {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_region")
    private Integer id;
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Comuna> comunas;
}
