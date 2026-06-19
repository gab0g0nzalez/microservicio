package com.donaton.usuarios_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;
    private int rut;
    private String dv;
    private String pnombre,snombre,papellido,sapellido;
    private String email;
    private int telefono;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Roles rol;
}
