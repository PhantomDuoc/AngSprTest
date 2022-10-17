package com.crudtest.crudtest;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonaControllerTest {

    @Test
    void hello(){
        PersonaController controller = new PersonaController(); //arrange
        List<Persona> response = controller.listar(); //act
    }
}
