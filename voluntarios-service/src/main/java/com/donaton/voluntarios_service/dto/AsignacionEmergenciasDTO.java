package com.donaton.voluntarios_service.dto;

import lombok.Data;

@Data
public class AsignacionEmergenciasDTO {
    private Integer id;
    private int id_emergencia;
    private String tarea;

    private EmergenciasDTO emergencias;
}
