package com.tp2.main.modelTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

import com.tp2.main.model.Banco;
import com.tp2.main.model.Cliente;

public class BancoTest {

    @Test
    public void testConstructor() {
        Banco banco = new Banco("Macro");
        assertNotNull(banco);
        assertEquals("Macro", banco.getNombreBanco());
        assertNotNull(banco.getClientes());
        assertTrue(banco.getClientes().isEmpty());
    }

    @Test
    public void testAddCliente() {
        Banco banco = new Banco("Macro");
        Cliente cliente1 = new Cliente();
        banco.addCliente(cliente1);
        
        List<Cliente> clientes = banco.getClientes();
        assertEquals(1, clientes.size());
        assertTrue(clientes.contains(cliente1));
    }
}
