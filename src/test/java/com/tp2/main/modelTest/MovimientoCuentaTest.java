package com.tp2.main.modelTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.tp2.main.model.MovimientoCuenta;
public class MovimientoCuentaTest {

    @Test
    public void testSetterGetter() {
        MovimientoCuenta movimiento = new MovimientoCuenta();
        movimiento.setHora("10:30");
        movimiento.setFecha("2024-05-15");
        movimiento.setTipoOperacion("Depósito");
        movimiento.setMonto(500.0);

        assertEquals("10:30", movimiento.getHora());
        assertEquals("2024-05-15", movimiento.getFecha());
        assertEquals("Depósito", movimiento.getTipoOperacion());
        assertEquals(500.0, movimiento.getMonto(), 0.001);
    }
}
