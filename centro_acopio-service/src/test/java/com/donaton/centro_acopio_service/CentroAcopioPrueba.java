package com.donaton.centro_acopio_service;

import com.donaton.centro_acopio_service.model.CentroAcopio;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CentroAcopioPrueba {
    @Test
    void registrarCurso(){
        //arrange (preaparar entorno)
        Faker faker= new Faker();
        CentroAcopio centroAcopio= new CentroAcopio();

        centroAcopio.setId(8291);
        centroAcopio.setNombre(faker.lorem().sentence());
        centroAcopio.setCiudad(faker.lorem().sentence());
        centroAcopio.setDireccion(faker.lorem().sentence());
        centroAcopio.setCapacidad(870);

        //ACT(ejecutar)
        System.out.println(centroAcopio);

        //ASSERT(verificar)
        assertNotNull(centroAcopio);
        assertNotNull(centroAcopio.getId());
        assertNotNull(centroAcopio.getNombre());
        assertNotNull(centroAcopio.getCiudad());
        assertNotNull(centroAcopio.getDireccion());
        assertNotNull(centroAcopio.getCapacidad());
    }
}
