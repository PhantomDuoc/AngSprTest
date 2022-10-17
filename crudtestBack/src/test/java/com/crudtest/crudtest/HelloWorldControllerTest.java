/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crudtest.crudtest;

import com.crudtest.crudtest.HelloWorldController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bizza
 */
public class HelloWorldControllerTest {
    
    @Test
    void hello(){
        HelloWorldController controller = new HelloWorldController();
        String response = controller.hello("World");
        assertEquals("Hello, World", response);
    }
    
}
