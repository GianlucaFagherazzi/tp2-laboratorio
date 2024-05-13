package com.tp2.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import com.tp2.main.model.Banco;

public class AppTest {

@Test
    public void testApp() {
        // Aquí puedes escribir pruebas para tu clase App
        // Por ejemplo:
        Banco banco = new Banco("Macro");
        assertNotNull(banco); // Verifica que el objeto banco no sea nulo
        assertEquals("Macro", banco.getNombreBanco()); // Verifica que el nombre del banco sea "Macro"
    }
}