package com.donaton.auditoria_service.dto;

import lombok.Data;

@Data
public class UsuariosDTO {
    private Integer id;
    private int rut;
    private String dv;
    private String pnombre,snombre,papellido,sapellido;
    private String email;
    private int telefono;
}
