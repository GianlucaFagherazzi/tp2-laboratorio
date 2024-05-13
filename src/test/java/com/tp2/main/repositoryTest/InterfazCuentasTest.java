package com.tp2.main.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import com.tp2.main.model.Banco;
import com.tp2.main.model.Cliente;
import com.tp2.main.repository.InterfazBasica;
import com.tp2.main.repository.InterfazCuentas;

public class InterfazCuentasTest {

    @Test
    public void testSeleccionarOpcion() {
        // Creamos un banco de ejemplo con un cliente registrado
        Banco banco = new Banco("Banco Ejemplo");
        Cliente cliente = new Cliente();
        banco.addCliente(cliente);

        // Simulamos la entrada del usuario (opción 3 para salir)
        String input = "3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Capturamos la salida del sistema
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Ejecutamos el método seleccionarOpcion
        InterfazCuentas interfazCuentas = new InterfazCuentas();
        interfazCuentas.seleccionarOpcion(banco);

        // Verificamos que el mensaje de salida sea correcto
        String expectedOutput = "Gestion de cuentas\n" +
                                "1. Crear cuenta\n" +
                                "2. Ver estado de la cuenta\n" +
                                "3. Salir";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
