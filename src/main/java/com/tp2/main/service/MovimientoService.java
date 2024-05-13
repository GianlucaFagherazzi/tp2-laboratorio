package com.tp2.main.service;
import com.tp2.main.model.MovimientoCuenta;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MovimientoService{
    public MovimientoCuenta registrarTransferencia(double monto){
        MovimientoCuenta movimiento = new MovimientoCuenta();
        movimiento.setTipoOperacion("Transferencia");
        movimiento.setMonto(monto);

        // Obtener la fecha actual
        LocalDateTime fecha = LocalDateTime.now();
        // Crear un formateador para mostrar solo el día (YYYY-MM-DD)
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Crear un formateador para mostrar solo la hora (HH:mm:ss)
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Formatear la fecha y mostrar solo el día
        String fechaFormateada = fecha.format(formatoFecha);
        // Formatear la fecha y hora y mostrar solo la hora
        String horaFormateada = fecha.format(formatoHora);

        movimiento.setFecha(fechaFormateada);
        movimiento.setHora(horaFormateada);

        return movimiento;
    }

    public MovimientoCuenta registrarRetiro(double monto){
        MovimientoCuenta movimiento = new MovimientoCuenta();
        movimiento.setTipoOperacion("Retiro");
        movimiento.setMonto(monto);

        // Obtener la fecha actual
        LocalDateTime fecha = LocalDateTime.now();
        // Crear un formateador para mostrar solo el día (YYYY-MM-DD)
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Crear un formateador para mostrar solo la hora (HH:mm:ss)
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Formatear la fecha y mostrar solo el día
        String fechaFormateada = fecha.format(formatoFecha);
        // Formatear la fecha y hora y mostrar solo la hora
        String horaFormateada = fecha.format(formatoHora);

        movimiento.setFecha(fechaFormateada);
        movimiento.setHora(horaFormateada);

        return movimiento;
    }

    public MovimientoCuenta registrarDeposito(double monto){
        MovimientoCuenta movimiento = new MovimientoCuenta();
        movimiento.setTipoOperacion("Deposito");
        movimiento.setMonto(monto);

        // Obtener la fecha y hora actual
        LocalDateTime fecha = LocalDateTime.now();
        // Crear un formateador para mostrar solo el día (YYYY-MM-DD)
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Crear un formateador para mostrar solo la hora (HH:mm:ss)
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Formatear la fecha y mostrar solo el día
        String fechaFormateada = fecha.format(formatoFecha);
        // Formatear la fecha y hora y mostrar solo la hora
        String horaFormateada = fecha.format(formatoHora);

        movimiento.setFecha(fechaFormateada);
        movimiento.setHora(horaFormateada);

        return movimiento;
    }
}
