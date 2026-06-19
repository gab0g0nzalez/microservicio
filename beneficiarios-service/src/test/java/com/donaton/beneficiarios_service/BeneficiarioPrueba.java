package com.donaton.beneficiarios_service;
import com.donaton.beneficiarios_service.model.Beneficiario;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class BeneficiarioPrueba {
    @Test
    void registrarCurso(){
        //arrange (preaparar entorno)
        Faker faker= new Faker();
        Beneficiario beneficiario = new Beneficiario();

        beneficiario.setId(1564);
        beneficiario.setNombre(faker.educator().course());
        beneficiario.setRut(faker.lorem().sentence());
        beneficiario.setTelefono(faker.lorem().sentence());


        //ACT(ejecutar)
        System.out.println(beneficiario);

        //ASSERT(verificar)
        assertNotNull(beneficiario);
        assertNotNull(beneficiario.getId());
        assertNotNull(beneficiario.getNombre());
        assertNotNull(beneficiario.getRut());
        assertNotNull(beneficiario.getTelefono());

    }
}
