package com.donaton.usuarios_service.model;

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
@Table(name = "roles")
public class Roles {

    enum ROL {
        ADMINISTRADOR, VOLUNTARIO, DONANTE, BENEFICIARIO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer id;
    @Enumerated(EnumType.STRING)
    private ROL nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<Usuarios> usuarios ;
}
