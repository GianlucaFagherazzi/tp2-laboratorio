package com.tp2.main.repository;

import com.tp2.main.model.*;

public class InterfazMenu extends InterfazBasica {
    /*esta sera la interfaz del menu principal, donde se podran realizaran las operaciones*/
    boolean exit = false;

    public void renderMenu(Banco banco) {
        clearScreen();
        while (!exit) {
            System.out.println("Bienvenido a la aplicación del banco " + banco.getNombreBanco());
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Cuentas");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción (1-3):");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    InterfazCliente interfazCliente = new InterfazCliente();
                    interfazCliente.seleccionarOpcion(banco);
                    break;
                case 2:
                    InterfazCuentas interfazCuentas = new InterfazCuentas();
                    interfazCuentas.seleccionarOpcion(banco);
                    break;
                case 3:
                    System.out.println("Gracias por utilizar la aplicación!");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-3.");
            }
        }
    }
}

