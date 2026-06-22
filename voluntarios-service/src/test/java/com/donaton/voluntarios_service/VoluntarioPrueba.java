package com.donaton.voluntarios_service;

import com.donaton.voluntarios_service.model.Voluntario;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class VoluntarioPrueba {
    @Test
    void registrarCurso() {
        //arrange (preaparar entorno)
        Faker faker = new Faker();
        Voluntario voluntario = new Voluntario();

        voluntario.setId(12);
        voluntario.setFecha_ingreso(LocalDate.now());
        voluntario.setId_usuario(2);
        voluntario.setDisponibilidad(false);

        System.out.println(voluntario);

        assertNotNull(voluntario);
        assertNotNull(voluntario.getId());
        assertNotNull(voluntario.getFecha_ingreso());
        assertNotNull(voluntario.getId_usuario());
        if (voluntario.getId_usuario()<1){
            throw new RuntimeException("Id menor a 1");
        }
        assertTrue(voluntario.isDisponibilidad());
    }
}