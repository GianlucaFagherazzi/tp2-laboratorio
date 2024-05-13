package com.tp2.main.repository;
import com.tp2.main.model.*;
import com.tp2.main.service.*;

public class InterfazCliente extends InterfazBasica {
    /*interfaz para crear un nuevo cliente */

    public void seleccionarOpcion(Banco banco) {
        boolean exit = false;
        while (!exit) {  
            System.out.println("Gestion de clientes");
            System.out.println("1. Mostrar clientes");
            System.out.println("2. Crear un nuevo Cliente");
            System.out.println("3. Modificar un cliente ya existente");
            System.out.println("4. Eliminar un cliente");
            System.out.println("5. Volver al menu");
            System.out.println("Seleccione una opcion (1-5):");

            int choice = scanner.nextInt();
            scanner.nextLine();

            ClienteService clienteService = new ClienteService();

            switch (choice) {
                case 1:
                    clearScreen();
                    clienteService.mostrarClientes(banco);
                    break;
                case 2:
                    clearScreen();
                    clienteService.crearCliente(banco);
                    break;
                case 3:
                    clearScreen();
                    clienteService.modificarCliente(banco);
                    break;
                case 4:
                    clearScreen();
                    clienteService.eliminarCliente(banco);
                    break;
                case 5:
                    clearScreen();
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-4.");
            }
        }
    }
}
