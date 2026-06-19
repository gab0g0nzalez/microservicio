package com.donaton.emergencias_service.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EmergenciaComunaDTO {
    private Integer id;
    private String descripcion;
    private LocalDate fecha_inicio;
    private String ubicacion;

    private ComunaDTO comuna;
}
