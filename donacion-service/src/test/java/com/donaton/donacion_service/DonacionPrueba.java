package com.donaton.donacion_service;

import com.donaton.donacion_service.model.Donacion;
import com.donaton.donacion_service.model.TipoDonacion;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DonacionPrueba {
    @Test
    void registrarCurso(){
        //arrange (preaparar entorno)
        Faker faker= new Faker();
        Donacion donacion = new Donacion();

        donacion.setId(6084);
        donacion.setId_centro(2371);
        donacion.setId_usuario(8821);
        donacion.setDescripcion(faker.lorem().sentence());
        donacion.setCantidad(3);
        donacion.setTipoDonacion(new TipoDonacion());
        donacion.setFecha_donacion(LocalDate.now());

        //ACT(ejecutar)
        System.out.println(donacion);

        //ASSERT(verificar)
        assertNotNull(donacion);
        assertNotNull(donacion.getId());
        assertNotNull(donacion.getId_usuario());
        assertNotNull(donacion.getId_centro());
        assertNotNull(donacion.getDescripcion());
        assertNotNull(donacion.getCantidad());
        assertNotNull(donacion.getTipoDonacion());
        assertNotNull(donacion.getFecha_donacion());

    }
}
