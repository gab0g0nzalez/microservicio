package com.donaton.transporte_service;

import com.donaton.transporte_service.model.Vehiculo;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class VehiculoPrueba {
    @Test
    void registrarCurso(){
        //arrange (preaparar entorno)
        Faker faker= new Faker();
        Vehiculo vehiculo = new Vehiculo();

        vehiculo.setId(1564);
        vehiculo.setPatente(faker.vehicle().licensePlate());
        vehiculo.setTipo("Camion");
        vehiculo.setCapacidad_carga_kg(faker.number().numberBetween(100, 5000));
        vehiculo.setEstado("Disponible");

        //ACT(ejecutar)
        System.out.println(vehiculo);

        //ASSERT(verificar)
        assertNotNull(vehiculo);
        assertNotNull(vehiculo.getId());
        assertNotNull(vehiculo.getPatente());
        assertNotNull(vehiculo.getTipo());
        assertNotNull(vehiculo.getCapacidad_carga_kg());
        assertNotNull(vehiculo.getEstado());
        assertEquals("Disponible", vehiculo.getEstado());
    }
}
