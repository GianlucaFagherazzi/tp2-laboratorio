package com.tp2.main.repository;
import com.tp2.main.model.*;
import com.tp2.main.service.*;

public class InterfazCuentas extends InterfazBasica{
    
    public void seleccionarOpcion(Banco banco){
        if (banco.getClientes().size() == 0) {
            System.out.println("No hay clientes registrados");
            return;    
        }

        boolean exit = false;
        while(!exit){
            System.out.println("Gestion de cuentas");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Ver estado de la cuenta");
            System.out.println("3. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine();

            CuentaService cuentaService = new CuentaService();

            switch(choice){
                case 1:
                    cuentaService.crearCuenta(banco);
                    break;
                case 2:
                    Cuenta cuenta = cuentaService.iniciarSesion(banco);
                    if (cuenta != null) {
                        clearScreen();
                        InterfazEstadoCuenta interfazEstadoCuenta = new InterfazEstadoCuenta();
                        interfazEstadoCuenta.seleccionarOpcion(cuenta, banco);
                    }
                    break;
                case 3:
                    clearScreen();
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-3.");
            }
        }
    }
}
