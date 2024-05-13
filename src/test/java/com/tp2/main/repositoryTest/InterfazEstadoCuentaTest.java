package com.tp2.main.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import com.tp2.main.model.Cuenta;
import com.tp2.main.model.Banco;
import com.tp2.main.repository.InterfazBasica;
import com.tp2.main.repository.InterfazEstadoCuenta;

public class InterfazEstadoCuentaTest {

    @Test
    public void testSeleccionarOpcion() {
        // Creamos una cuenta de ejemplo y un banco asociado
        Cuenta cuenta = new Cuenta();
        Banco banco = new Banco("Banco Ejemplo");

        // Simulamos la entrada del usuario (opción 6 para salir)
        String input = "6\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Capturamos la salida del sistema
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Ejecutamos el método seleccionarOpcion
        InterfazEstadoCuenta interfazEstadoCuenta = new InterfazEstadoCuenta();
        interfazEstadoCuenta.seleccionarOpcion(cuenta, banco);

        // Verificamos que el mensaje de salida sea correcto
        String expectedOutput = "Gestion de la cuenta\n" +
                                "1. Estado de la cuenta\n" +
                                "2. Realizar un deposito\n" +
                                "3. Realizar un retiro\n" +
                                "4. Realizar una transferencia\n" +
                                "5. Historial de transferencias\n" +
                                "6. Salir";
        assertEquals(expectedOutput, outputStream.toString());
    }
}

