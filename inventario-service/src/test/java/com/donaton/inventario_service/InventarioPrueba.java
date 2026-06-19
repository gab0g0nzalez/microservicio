package com.donaton.inventario_service;

import com.donaton.inventario_service.model.Inventario;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class InventarioPrueba {
    @Test
    void registrarCurso(){
        //arrange (preaparar entorno)
        Faker faker= new Faker();
        Inventario inventario = new Inventario();

        inventario.setId(1564);
        inventario.setStock_actual(faker.number().numberBetween(1, 500));
        inventario.setFecha_actualizacion(LocalDateTime.now());
        inventario.setId_donacion(faker.number().numberBetween(1, 999));

        //ACT(ejecutar)
        System.out.println(inventario);

        //ASSERT(verificar)
        assertNotNull(inventario);
        assertNotNull(inventario.getId());
        assertNotNull(inventario.getStock_actual());
        assertNotNull(inventario.getFecha_actualizacion());
        assertNotNull(inventario.getId_donacion());
        assertEquals(1564, inventario.getId());
    }
}