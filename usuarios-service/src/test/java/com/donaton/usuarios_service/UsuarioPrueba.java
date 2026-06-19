package com.donaton.usuarios_service;

import com.donaton.usuarios_service.model.Roles;
import com.donaton.usuarios_service.model.Usuarios;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class UsuarioPrueba {
    @Test
    void registrarCurso(){
        //arrange (preaparar entorno)
        Faker faker= new Faker();
        Usuarios usuario = new Usuarios();

        usuario.setId(1564);
        usuario.setRut(faker.number().numberBetween(10000000, 25000000));
        usuario.setDv(String.valueOf(faker.number().numberBetween(0, 9)));
        usuario.setPnombre(faker.name().firstName());
        usuario.setSnombre(faker.name().firstName());
        usuario.setPapellido(faker.name().lastName());
        usuario.setSapellido(faker.name().lastName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setTelefono(faker.number().numberBetween(900000000, 999999999));
        usuario.setRol(new Roles());

        //ACT(ejecutar)
        System.out.println(usuario);

        //ASSERT(verificar)
        assertNotNull(usuario);
        assertNotNull(usuario.getId());
        assertNotNull(usuario.getRut());
        assertNotNull(usuario.getDv());
        assertNotNull(usuario.getPnombre());
        assertNotNull(usuario.getSnombre());
        assertNotNull(usuario.getPapellido());
        assertNotNull(usuario.getSapellido());
        assertNotNull(usuario.getEmail());
        assertNotNull(usuario.getTelefono());
        assertNotNull(usuario.getRol());
        assertEquals(1564, usuario.getId());
    }
}
