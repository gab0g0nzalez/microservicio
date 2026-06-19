package com.donaton.donacion_service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DonacionUsuariosDTO {
    private Integer id;
    private String descripcion;
    private int cantidad;
    private LocalDate fecha_donacion;
    private Boolean estado=true;

    private UsuariosDTO usuariosDTO;

}
