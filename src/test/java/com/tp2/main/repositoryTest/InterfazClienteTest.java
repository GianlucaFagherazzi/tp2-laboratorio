package com.tp2.main.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import com.tp2.main.model.Banco;
import com.tp2.main.repository.InterfazCliente;
import com.tp2.main.repository.InterfazBasica;

public class InterfazClienteTest {

    @Test
    public void testSeleccionarOpcion() {
        // Creamos un banco de ejemplo
        Banco banco = new Banco("Banco Ejemplo");

        // Simulamos la entrada del usuario (opción 5 para volver al menú)
        String input = "5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Capturamos la salida del sistema
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Ejecutamos el método seleccionarOpcion
        InterfazCliente interfazCliente = new InterfazCliente();
        interfazCliente.seleccionarOpcion(banco);

        // Verificamos que el mensaje de salida sea correcto
        String expectedOutput = "Gestion de clientes\n" +
                                "1. Mostrar clientes\n" +
                                "2. Crear un nuevo Cliente\n" +
                                "3. Modificar un cliente ya existente\n" +
                                "4. Eliminar un cliente\n" +
                                "5. Volver al menu\n" +
                                "Seleccione una opcion (1-5):\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}