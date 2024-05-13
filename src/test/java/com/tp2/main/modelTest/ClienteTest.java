package com.tp2.main.modelTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.tp2.main.model.Cliente;
import com.tp2.main.model.Cuenta;
import java.time.LocalDate;
import java.util.Set;

public class ClienteTest {

    @Test
    public void testSetterGetter() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellido("Perez");
        cliente.setDni("12345678");
        cliente.setTelefono("123456789");
        cliente.setDireccion("Calle 123");
        cliente.setFechaNacimiento(LocalDate.of(1990, 5, 15));
        cliente.setTipoPersona("Física");
        cliente.setFechaAlta(LocalDate.now());

        assertEquals("Juan", cliente.getNombre());
        assertEquals("Perez", cliente.getApellido());
        assertEquals("12345678", cliente.getDni());
        assertEquals("123456789", cliente.getTelefono());
        assertEquals("Calle 123", cliente.getDireccion());
        assertEquals(LocalDate.of(1990, 5, 15), cliente.getFechaNacimiento());
        assertEquals("Física", cliente.getTipoPersona());
        assertNotNull(cliente.getFechaAlta());
    }

    @Test
    public void testAddCuenta() {
        Cliente cliente = new Cliente();
        Cuenta cuenta1 = new Cuenta();
        Cuenta cuenta2 = new Cuenta();
        
        cliente.addCuenta(cuenta1);
        cliente.addCuenta(cuenta2);

        Set<Cuenta> cuentas = cliente.getCuentas();
        assertEquals(2, cuentas.size());
        assertTrue(cuentas.contains(cuenta1));
        assertTrue(cuentas.contains(cuenta2));
    }

    @Test
    public void testDatosCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellido("Perez");
        cliente.setDni("12345678");
        cliente.setTelefono("123456789");
        cliente.setDireccion("Calle 123");
        cliente.setFechaNacimiento(LocalDate.of(1990, 5, 15));
        cliente.setTipoPersona("Física");
        cliente.setFechaAlta(LocalDate.now());

        String datosCliente = cliente.datosCliente();

        assertTrue(datosCliente.contains("Nombre: Juan"));
        assertTrue(datosCliente.contains("Apellido: Perez"));
        assertTrue(datosCliente.contains("DNI: 12345678"));
        assertTrue(datosCliente.contains("Telefono: 123456789"));
        assertTrue(datosCliente.contains("Direccion: Calle 123"));
        assertTrue(datosCliente.contains("Fecha de nacimiento: 1990-05-15"));
        assertTrue(datosCliente.contains("Tipo de persona: Física"));
        assertNotNull(cliente.getFechaAlta());
    }
}
