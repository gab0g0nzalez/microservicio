package com.donaton.emergencias_service;

import com.donaton.emergencias_service.model.Emergencia;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmergenciaPrueba {
    @Test
    void registrarCurso(){
        //arrange (preaparar entorno)
        Faker faker= new Faker();
        Emergencia emergencia = new Emergencia();

        emergencia.setId(6084);
        emergencia.setDescripcion(faker.lorem().sentence());
        emergencia.setFecha_inicio(LocalDate.now());
        emergencia.setUbicacion(faker.address().fullAddress());
        emergencia.setComuna(faker.number().numberBetween(1, 346));

        //ACT(ejecutar)
        System.out.println(emergencia);

        //ASSERT(verificar)
        assertNotNull(emergencia);
        assertNotNull(emergencia.getId());
        assertNotNull(emergencia.getDescripcion());
        assertNotNull(emergencia.getFecha_inicio());
        assertNotNull(emergencia.getUbicacion());
        assertNotNull(emergencia.getComuna());
        assertEquals(6084, emergencia.getId());
    }
}
