package com.donaton.auditoria_service;

import com.donaton.auditoria_service.model.Auditoria;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class AuditoriaPrueba    {
    @Test
    void registrarCurso(){
        //arrange (preaparar entorno)
        Faker faker= new Faker();
        Auditoria auditoria= new Auditoria();

        auditoria.setId(1564);
        auditoria.setDescripcion(faker.educator().course());
        auditoria.setFecha_hora(LocalDateTime.now());
        auditoria.setDescripcion(faker.lorem().sentence());
        auditoria.setAccion("Actualizar");

        //ACT(ejecutar)
        System.out.println(auditoria);

        //ASSERT(verificar)
        assertNotNull(auditoria);
        assertNotNull(auditoria.getId());
        assertNotNull(auditoria.getDescripcion());
        assertNotNull(auditoria.getFecha_hora());
        assertNotNull(auditoria.getAccion());
        assertEquals("Actualizar",auditoria.getAccion());
    }
}
