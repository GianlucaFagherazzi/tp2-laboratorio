package com.tp2.main.service;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;

import com.tp2.main.model.*;

public class ClienteService {
    /*esta clase se encargara de gestionar la logica del cliente */
    public void mostrarClientes(Banco banco) {
        List <Cliente> clientes = banco.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
        }
        else{
            System.out.println("Listado de clientes");

            for (Cliente cliente : banco.getClientes()) {
                System.out.println(cliente.datosCliente());
            }
        }
    }

    public void crearCliente(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        // Ingreso de datos del Cliente
        Cliente cliente = new Cliente();
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        cliente.setNombre(nombre);

        System.out.println("Ingrese el apellido del cliente:");
        String apellido = scanner.nextLine();
        cliente.setApellido(apellido);

        System.out.println("Ingrese el DNI del cliente:");
        String dni = scanner.nextLine();

        boolean existente = false;
        List <Cliente> clientesBanco = banco.getClientes();
        Cliente clienteBuscar = null;
        for (int i = 0; i < clientesBanco.size(); i++) {
            clienteBuscar = clientesBanco.get(i);
            if (clienteBuscar.getDni().equals(dni)) {
                existente = true;
                break;
            }
        }

        if (existente) {
            System.out.println("El cliente ya existe");
            return;
        }
        
        cliente.setDni(dni);

        System.out.println("Ingrese el telefono del cliente:");
        String telefono = scanner.nextLine();
        cliente.setTelefono(telefono);

        System.out.println("Ingrese la direccion del cliente:");
        String direccion = scanner.nextLine();
        cliente.setDireccion(direccion);

        System.out.println("Ingrese la fecha nacimiento del cliente(Formato: YYYY-MM-DD):");
        LocalDate fechaNacimiento = null;
        boolean fechaCorrecta = false;
        while (!fechaCorrecta) {
            try {
                fechaNacimiento = LocalDate.parse(scanner.nextLine());
                fechaCorrecta = true;
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Ingrese la fecha en formato YYYY-MM-DD:");
            }
        }
        cliente.setFechaNacimiento(fechaNacimiento);

        System.out.println("Ingrese el tipo de persona: F para Física o J para Jurídica:");
        String tipoPersonaStr = scanner.nextLine().toUpperCase();
        while (!tipoPersonaStr.equals("F") && !tipoPersonaStr.equals("J")) {
            System.out.println("Tipo de persona inválido. Por favor, ingrese F para Física o J para Jurídica:");
            tipoPersonaStr = scanner.nextLine().toUpperCase();
        }
        cliente.setTipoPersona(tipoPersonaStr);

        LocalDate fechaAlta = LocalDate.now();
        cliente.setFechaAlta(fechaAlta);

        banco.addCliente(cliente);
        System.out.println("Cliente creado con éxito!");
        System.out.print(cliente.datosCliente());
    }

    public void modificarCliente(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba el dni del cliente a modificar");
        String dni = scanner.nextLine();

        List <Cliente> clientes = banco.getClientes();
        boolean encontrado = false;
        Cliente cliente = null;
        int indice = 0;
        for (int i = 0; i < clientes.size(); i++) {
            cliente = clientes.get(i);
            if (cliente.getDni().equals(dni)) {
                // Se encontró el cliente con el DNI dado
                encontrado = true;
                indice = i;
                break;
            }
        } 

        if (encontrado) {
            System.out.println("Cliente encontrado");
            System.out.println("Ingrese que propiedad desea modificar:");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. DNI");
            System.out.println("4. Telefono");
            System.out.println("5. Direccion");
            System.out.println("6. Fecha de nacimiento");
            System.out.println("7. Tipo de persona");
            System.out.println("8. Cancelar");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume el carácter de nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre del cliente:");
                    String nuevoNombre = scanner.nextLine();
                    cliente.setNombre(nuevoNombre);
                    System.out.println("Cliente modificado con éxito");
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo apellido del cliente:");
                    String nuevoApellido = scanner.nextLine();
                    cliente.setApellido(nuevoApellido);
                    System.out.println("Cliente modificado con éxito");
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo DNI del cliente:");
                    String nuevoDNI = scanner.nextLine();
                    cliente.setDni(nuevoDNI);
                    System.out.println("Cliente modificado con éxito");
                    break;
                case 4:
                    System.out.println("Ingrese el nuevo telefono del cliente:");
                    String nuevoTelefono = scanner.nextLine();
                    cliente.setApellido(nuevoTelefono);
                    System.out.println("Cliente modificado con éxito");
                    break;
                case 5:
                    System.out.println("Ingrese la nueva direccion del cliente:");
                    String nuevaDireccion = scanner.nextLine();
                    cliente.setApellido(nuevaDireccion);
                    System.out.println("Cliente modificado con éxito");
                    break;
                case 6:
                    System.out.println("Ingrese la nueva fecha de nacimiento del cliente:");
                    LocalDate fechaNacimiento = null;
                    boolean fechaValida = false;
                    while (!fechaValida) {
                        try {
                            fechaNacimiento = LocalDate.parse(scanner.nextLine());
                            fechaValida = true;
                        } catch (Exception e) {
                            System.out.println("Formato de fecha inválido. Ingrese la fecha en formato YYYY-MM-DD:");
                        }
                    }
                    cliente.setFechaNacimiento(fechaNacimiento);
                    System.out.println("Cliente modificado con éxito");
                    break;
                case 7:
                    System.out.println("Ingrese el nuevo tipo de persona del cliente:");
                    String nuevoTipoPersona = scanner.nextLine();
                    cliente.setTipoPersona(nuevoTipoPersona);
                    System.out.println("Cliente modificado con éxito");
                    break;
                case 8:
                    System.out.println("Modificación cancelada");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
            // Remplazo el elemento en el indice indicado
            clientes.set(indice, cliente);
        }
        else{
            System.out.println("Cliente no encontrado");
        }
    }

    public void eliminarCliente(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba el dni del cliente a eliminar");
        String dni = scanner.nextLine();

        List <Cliente> clientes = banco.getClientes();
        boolean encontrado = false;
        Cliente cliente = null;
        int indice = 0;
        for (int i = 0; i < clientes.size(); i++) {
            cliente = clientes.get(i);
            if (cliente.getDni().equals(dni)) {
                // Se encontró el cliente con el DNI dado
                encontrado = true;
                indice = i;
                break;
            }
        } 

        if (encontrado) {
            clientes.remove(indice);
            System.out.println("Cliente eliminado con éxito");
        }
        else{
            System.out.println("Cliente no encontrado");
            
        }
    }

    public Cliente buscarCliente(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba el dni del cliente a buscar");
        String dni = scanner.nextLine();

        List <Cliente> clientes = banco.getClientes();
        Cliente cliente = null;
        for (int i = 0; i < clientes.size(); i++) {
            cliente = clientes.get(i);
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }
}


