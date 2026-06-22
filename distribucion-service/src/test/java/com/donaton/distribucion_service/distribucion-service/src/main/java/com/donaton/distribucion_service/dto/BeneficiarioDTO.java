package com.donaton.distribucion_service.distribucion;

import lombok.Data;

@Data
public class BeneficiarioDTO {
    private Integer id;
    private String nombre;
    private String rut;
    private String telefono;
    private Integer id_comuna;
}
