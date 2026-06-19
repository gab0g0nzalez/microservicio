package com.donaton.auditoria_service.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AuditoriaUsuarioDTO {
    private Integer id;
    private String accion;
    private LocalDateTime fecha_hora;
    private String descripcion;

    private UsuariosDTO usuarioDto;
}
