package com.donaton.voluntarios_service.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmergenciasDTO {
    private Integer id_emergencia;
    private String descripcion;
    private String ubicacion;
    private Date fecha_inicio;
    private String estado;
}
