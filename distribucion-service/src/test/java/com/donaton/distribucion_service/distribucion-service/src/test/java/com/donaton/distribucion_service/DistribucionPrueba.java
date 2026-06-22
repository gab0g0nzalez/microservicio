package com.donaton.distribucion_service.distribucion;

import com.donaton.distribucion_service.model.Distribucion;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DistribucionPrueba {
    @Test
    void registrarCurso(){
        //arrange (preaparar entorno)
        Faker faker= new Faker();
        Distribucion distribucion= new Distribucion();

        distribucion.setId(6084);
        distribucion.setId_donacion(4382);
        distribucion.setId_emergencia(4721);
        distribucion.setId_beneficiario(8539);
        distribucion.setFecha_entrega(LocalDate.now());
        distribucion.setCantidad_entregada(0);

        //ACT(ejecutar)
        System.out.println(distribucion);

        //ASSERT(verificar)
        assertNotNull(distribucion);
        assertNotNull(distribucion.getId());
        assertNotNull(distribucion.getId_donacion());
        assertNotNull(distribucion.getId_emergencia());
        assertNotNull(distribucion.getId_beneficiario());

    }


}
