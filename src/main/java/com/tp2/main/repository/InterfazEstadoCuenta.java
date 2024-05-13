package com.tp2.main.repository;
import com.tp2.main.model.*;
import com.tp2.main.service.*;

public class InterfazEstadoCuenta extends InterfazBasica{

    public void seleccionarOpcion(Cuenta cuenta, Banco banco){
        boolean exit = false;
        while(!exit){
            System.out.println("Gestion de la cuenta");
            System.out.println("1. Estado de la cuenta");
            System.out.println("2. Realizar un deposito");
            System.out.println("3. Realizar un retiro");
            System.out.println("4. Realizar una transferencia");
            System.out.println("5. Historial de transferencias");
            System.out.println("6. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine();

            CuentaService cuentaService = new CuentaService();

            switch(choice){
                case 1:
                    cuentaService.verEstadoCuenta(cuenta);
                    break;
                case 2:
                    cuentaService.depositar(cuenta);
                    break;
                case 3:
                    cuentaService.retirar(cuenta);
                    break;
                case 4:
                    cuentaService.transferir(cuenta, banco);
                    break;
                case 5:
                    cuentaService.historialMovimientos(cuenta);
                    break;
                case 6:
                    clearScreen();
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-5.");
                    break;
            
            }
        }
    }
}
