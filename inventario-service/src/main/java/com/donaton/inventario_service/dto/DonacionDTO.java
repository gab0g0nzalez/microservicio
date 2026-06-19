package com.donaton.inventario_service.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DonacionDTO {
    private Integer id;
    private String descripcion;
    private int cantidad;
    private LocalDate fecha_donacion;
    private Boolean estado=true;

}
