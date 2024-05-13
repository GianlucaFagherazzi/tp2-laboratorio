package com.tp2.main.service;

import com.tp2.main.model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class CuentaService {
    private static int numeroCuenta = 1;

    /* esta clase se encargara de gestionar la logica de las cuentas */
    public void crearCuenta(Banco banco) {
        // aqui se creara la cuenta
        Scanner scanner = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        Cliente cliente = clienteService.buscarCliente(banco);

        if (cliente == null) {
            System.out.println("No se encontró el cliente con el DNI dado");
            return;
        }

        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(numeroCuenta);
        cuenta.setFechaCreacion(LocalDate.now());
        cuenta.setBalance(0);

        System.out.println("Ingrese el tipo de cuenta");
        String tipoCuenta = scanner.nextLine();
        cuenta.setTipoCuenta(tipoCuenta);

        cliente.getCuentas().add(cuenta);
        System.out.println("Cuenta creada con éxito");
        System.out.println("Su numero de cuenta es: " + numeroCuenta);
        numeroCuenta++;
    }

    public void verEstadoCuenta(Cuenta cuenta) {
        // aqui se mostrara el estado de la cuenta
        System.out.println("Estado de la cuenta");
        System.out.println("Numero de cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Fecha de creacion: " + cuenta.getFechaCreacion());
        System.out.println("Tipo de cuenta: " + cuenta.getTipoCuenta());
        System.out.println("Balance: " + cuenta.getBalance());
        System.out.println("---------------------------------");
    }

    public void depositar(Cuenta cuenta) {
        // aqui se realizara el deposito
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el monto a depositar");
        double saldo = scanner.nextDouble();

        if (saldo < 0) {
            System.out.println("El saldo no puede ser negativo");
            return;
        }

        cuenta.setBalance(cuenta.getBalance() + saldo);
        System.out.println("Saldo depositado con éxito");
        System.out.println("Saldo actual: " + cuenta.getBalance());

        MovimientoService movimientoService = new MovimientoService();
        MovimientoCuenta movimiento = movimientoService.registrarDeposito(saldo);
        cuenta.getMovimientosCuenta().add(movimiento);
    }

    public void retirar(Cuenta cuenta) {
        // aqui se realizara el retiro
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el monto a retirar");
        double saldo = scanner.nextDouble();

        if (saldo <= 0) {
            System.out.println("El saldo no puede ser negativo");
            return;
        } else if (saldo > cuenta.getBalance()) {
            System.out.println("El saldo a retirar no puede ser mayor al saldo actual");
            return;
        }

        cuenta.setBalance(cuenta.getBalance() - saldo);
        System.out.println("Saldo retirado con éxito");
        System.out.println("Saldo actual: " + cuenta.getBalance());

        MovimientoService movimientoService = new MovimientoService();
        MovimientoCuenta movimiento = movimientoService.registrarRetiro(saldo);
        cuenta.getMovimientosCuenta().add(movimiento);
    }

    public void transferir(Cuenta cuenta, Banco banco) {
        // aqui se realizara la transferencia
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de cuenta a transferir");
        int numeroCuenta = scanner.nextInt();

        for (Cliente cliente : banco.getClientes()) {
            for (Cuenta cuentaCliente : cliente.getCuentas()) {
                if (cuentaCliente.getNumeroCuenta() == numeroCuenta) {
                    System.out.println("Cuenta encontrada");
                    System.out.println("Ingrese el monto a transferir");
                    double saldo = scanner.nextDouble();

                    if (saldo < 0) {
                        System.out.println("El saldo no puede ser negativo");
                        return;
                    } else if (saldo > cuenta.getBalance()) {
                        System.out.println("El saldo a transferir no puede ser mayor al saldo actual");
                        return;
                    } else {
                        cuenta.setBalance(cuenta.getBalance() - saldo);
                        cuentaCliente.setBalance(cuentaCliente.getBalance() + saldo);
                        System.out.println("Transferencia realizada con éxito");
                        System.out.println("Saldo actual: " + cuenta.getBalance());

                        MovimientoService movimientoService = new MovimientoService();
                        MovimientoCuenta movimiento = movimientoService.registrarTransferencia(saldo);
                        cuenta.getMovimientosCuenta().add(movimiento);
                        return;
                    }
                }
            }
        }
        System.out.println("No se encontro la cuenta a transferir");
    }

    public Cuenta buscarCuenta(Cliente cliente, int numeroCuenta) {
        for (Cuenta cuenta : cliente.getCuentas()) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                return cuenta;
            }
        }
        return null;
    }

    public Cuenta iniciarSesion(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new ClienteService().buscarCliente(banco);
        if (cliente == null) {
            System.out.println("No se encontro el cliente");
            return null;
        }

        if(cliente.getCuentas().isEmpty()){
            System.out.println("El cliente no tiene cuentas");
            return null;
        }

        System.out.println("Ingrese su numero de cuenta: ");
        int numeroCuenta = scanner.nextInt();
        scanner.nextLine();

        Cuenta cuenta = buscarCuenta(cliente, numeroCuenta);
        if (cuenta == null) {
            System.out.println("No se encontro la cuenta");
            return null;
        }
        return cuenta;
    }

    public void historialMovimientos(Cuenta cuenta){
        // aqui se mostrara el historial de movimientos
        if (cuenta.getMovimientosCuenta().isEmpty()) {
            System.out.println("No hay movimientos para mostrar");
            return;
        }

        for (MovimientoCuenta movimiento : cuenta.getMovimientosCuenta()) {
            System.out.println("---------------------------------");
            System.out.println("Fecha: " + movimiento.getFecha());
            System.out.println("Hora: " + movimiento.getHora());
            System.out.println("Tipo: " + movimiento.getTipoOperacion());
            System.out.println("Monto: " + movimiento.getMonto());
            System.out.println("---------------------------------");
        }
    }
}
