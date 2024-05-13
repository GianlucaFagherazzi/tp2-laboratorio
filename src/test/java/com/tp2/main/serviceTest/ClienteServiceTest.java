package com.tp2.main.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tp2.main.model.Banco;
import com.tp2.main.model.Cliente;
import com.tp2.main.service.*;

public class ClienteServiceTest {

    private ClienteService clienteService;
    private Banco banco;

    @BeforeEach
    public void setUp() {
        clienteService = new ClienteService();
        banco = new Banco("Banco Ejemplo");
    }

    @Test
    public void testMostrarClientes_EmptyBanco() {
        // Arrange
        String expectedOutput = "No hay clientes registrados\n";
        // Act
        String actualOutput = captureOutput(() -> clienteService.mostrarClientes(banco));
        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCrearCliente() {
        // Arrange
        String input = "Juan\nPerez\n12345678\n1234567890\nCalle 123\n1990-01-01\nF\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // Act
        clienteService.crearCliente(banco);
        List<Cliente> clientes = banco.getClientes();
        Cliente cliente = clientes.get(0);
        // Assert
        assertEquals("Juan", cliente.getNombre());
        assertEquals("Perez", cliente.getApellido());
        assertEquals("12345678", cliente.getDni());
        assertEquals("1234567890", cliente.getTelefono());
        assertEquals("Calle 123", cliente.getDireccion());
        assertEquals(LocalDate.of(1990, 1, 1), cliente.getFechaNacimiento());
        assertEquals("F", cliente.getTipoPersona());
    }

    // Método para capturar la salida estándar
    private String captureOutput(Runnable code) {
        // Guarda la salida estándar actual
        PrintStream originalOut = System.out;
        try {
            // Redirige la salida estándar a un nuevo flujo
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            System.setOut(printStream);
            // Ejecuta el código
            code.run();
            // Devuelve la salida capturada como una cadena
            return outputStream.toString();
        } finally {
            // Restaura la salida estándar original
            System.setOut(originalOut);
        }
    }
}

