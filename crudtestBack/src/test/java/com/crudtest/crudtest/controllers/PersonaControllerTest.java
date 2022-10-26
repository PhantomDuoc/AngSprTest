package com.crudtest.crudtest.controllers;

import com.crudtest.crudtest.models.entity.Persona;
import com.crudtest.crudtest.models.repositories.PersonaRepository;
import com.crudtest.crudtest.models.services.PersonaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonaController.class)
@ComponentScan(basePackages = "com.crudtest.crudtest.*")
class PersonaControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonaRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void listar() {
    }

    @Test
    void save() {
    }

    @Test
    void listarId() throws Exception {
        final int userId = 1;
        Persona MockPersona = new Persona(userId, "Hugo", "Cerda");
        Mockito.doReturn(MockPersona).when(repository).findById(userId);

        final String expectedResponse = objectMapper.writeValueAsString(MockPersona);

        mvc.perform(get("/personas/"+userId)).andExpect(status().isOk()).andExpect(content().json(expectedResponse));

        verify(repository).findById(userId);

    }

    @Test
    void listarId1() throws Exception {
        final int userId = 1;
        Persona MockPersona = new Persona(userId, "Hugo", "Cerda");
        Mockito.doReturn(MockPersona).when(repository).findById(userId);

        final String expectedResponse = objectMapper.writeValueAsString(MockPersona);

        mvc.perform(get("/personas/"+userId)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(userId)))
                .andExpect(jsonPath("$.nombres",is("Hugo")))
                .andExpect(jsonPath("$.apellidos",is("Cerda")));

        /*
        * The upside of this is that you do not have to evaluate the entire response.
        *  This may be useful if, for example, the server response includes server-generated data
        *  that is difficult to replicate or mock without doing away with too much of the actual
        *  code logic (via e.g. mocking). In this case, you could check for the presence of the field,
        *  without regard for its actual value, e.g.:
        * .andExpect(jsonPath("$.serverGeneratedSecretKey", notNullValue()))
        *
        *
        * Note that if you had e.g. an array of response objects,
        * you could parse them with the proper array notation, e.g.:
        * .andExpect(jsonPath("$[0].name", is("Mary")))
        *
        *  */

        verify(repository).findById(userId);

    }

    @Test
    void listarId2() throws Exception {
        final int userId = 1;
        Persona MockPersona = new Persona(userId, "Hugo", "Cerda");
        Mockito.doReturn(MockPersona).when(repository).findById(userId);

        String expectedResponse = "{\"id\":1,\"nombres\":\"Hugo\",\"apellidos\":\"Cerda\"}";

        String responseString = mvc.perform(get("/personas/"+userId))
                               .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(expectedResponse, responseString);

        verify(repository).findById(userId);

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}