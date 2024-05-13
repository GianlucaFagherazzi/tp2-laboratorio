package com.tp2.main.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import com.tp2.main.model.Banco;
import com.tp2.main.repository.InterfazMenu;
public class InterfazMenuTest {

    @Test
    public void testRenderMenu() {
        // Creamos un banco de ejemplo
        Banco banco = new Banco("Banco Ejemplo");

        // Simulamos la entrada del usuario (opción 3 para salir)
        String input = "3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Capturamos la salida del sistema
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Ejecutamos el método renderMenu
        InterfazMenu interfazMenu = new InterfazMenu();
        interfazMenu.renderMenu(banco);

        // Verificamos que el mensaje de salida sea correcto
        String expectedOutput = "Bienvenido a la aplicación del banco Banco Ejemplo\n" +
                                "1. Gestionar Clientes\n" +
                                "2. Gestionar Cuentas\n" +
                                "3. Salir\n" +
                                "Ingrese su opción (1-3):" +
                                "Gracias por utilizar la aplicación!";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
