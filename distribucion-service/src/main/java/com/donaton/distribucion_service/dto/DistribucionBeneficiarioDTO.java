package com.donaton.distribucion_service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DistribucionBeneficiarioDTO {
    private Integer id_distribucion;
    private LocalDate fecha_entrega;
    private int cantidad_entregada;

    private BeneficiarioDTO beneficiario;
}
