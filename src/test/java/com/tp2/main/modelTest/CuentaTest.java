package com.tp2.main.modelTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.tp2.main.model.Cuenta;
import com.tp2.main.model.MovimientoCuenta;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CuentaTest {

    @Test
    public void testSetterGetter() {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(12345);
        cuenta.setTipoCuenta("Corriente");
        cuenta.setFechaCreacion(LocalDate.of(2022, 5, 12));
        cuenta.setBalance(1000.0);

        assertEquals(12345, cuenta.getNumeroCuenta());
        assertEquals("Corriente", cuenta.getTipoCuenta());
        assertEquals(LocalDate.of(2022, 5, 12), cuenta.getFechaCreacion());
        assertEquals(1000.0, cuenta.getBalance(), 0.001);
    }

    @Test
    public void testMovimientosCuenta() {
        Cuenta cuenta = new Cuenta();
        LocalDateTime ahora = LocalDateTime.now();
        LocalDate fechaActual = ahora.toLocalDate();

        MovimientoCuenta movimiento1 = new MovimientoCuenta();
        movimiento1.setFecha(fechaActual.toString());
        movimiento1.setHora(ahora.toLocalTime().toString());
        movimiento1.setTipoOperacion("Depósito");
        movimiento1.setMonto(500.0);

        MovimientoCuenta movimiento2 = new MovimientoCuenta();
        movimiento2.setFecha(fechaActual.toString());
        movimiento2.setHora(ahora.toLocalTime().toString());
        movimiento2.setTipoOperacion("Retiro");
        movimiento2.setMonto(-200.0);
        
        cuenta.getMovimientosCuenta().add(movimiento1);
        cuenta.getMovimientosCuenta().add(movimiento2);

        List<MovimientoCuenta> movimientos = cuenta.getMovimientosCuenta();
        assertEquals(2, movimientos.size());
        assertEquals(movimiento1, movimientos.get(0));
        assertEquals(movimiento2, movimientos.get(1));
    }
}
