package com.crudtest.crudtest;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonaController.class)
@ComponentScan(basePackages = "com.crudtest.crudtest.*")
public class PersonaControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private PersonaService service;
    
    @MockBean
    private PersonaRepository repository;
    
    @Test
    void hello(){
        PersonaController controller = new PersonaController(); //arrange
        List<Persona> response = controller.listar(); //act
    }
    
    @Test
    public void testFindById() throws Exception {
        mvc.perform(get("/personas/1")).andExpect(status().isOk());
    }
}
