package com.donaton.donacion_service.dto;

import lombok.Data;

@Data
public class UsuariosDTO {
    private Integer id_usuario;
    private int rut;
    private String dv;
    private String pnombre,snombre,papellido,sapellido;
    private String email;
    private int telefono;
    private int id_rol;
}
