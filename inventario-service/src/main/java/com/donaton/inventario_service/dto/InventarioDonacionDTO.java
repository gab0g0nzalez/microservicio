package com.donaton.inventario_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InventarioDonacionDTO {
    private Integer id_inventario;
    private int stock_actual;
    private LocalDateTime fecha_actualizacion;

    private DonacionDTO donacion;
}
