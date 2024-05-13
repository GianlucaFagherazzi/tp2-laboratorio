package com.tp2.main.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Cliente extends Persona{
    private String tipoPersona;
    private LocalDate fechaAlta;
    private Set<Cuenta> cuentas = new HashSet<>();

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Set<Cuenta> getCuentas() {
        return cuentas;
    }

    public void addCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }

    public String datosCliente() {
        String datosCliente = "";
        datosCliente += "Nombre: " + this.getNombre() + "\n";
        datosCliente += "Apellido: " + this.getApellido() + "\n";
        datosCliente += "DNI: " + this.getDni() + "\n";
        datosCliente += "Telefono: " + this.getTelefono() + "\n";
        datosCliente += "Direccion: " + this.getDireccion() + "\n";
        datosCliente += "Fecha de nacimiento: " + this.getFechaNacimiento() + "\n";
        datosCliente += "Tipo de persona: " + this.getTipoPersona() + "\n";
        datosCliente += "Fecha de alta: " + this.getFechaAlta() + "\n";
        datosCliente += "----------------------------------------------\n";
        return datosCliente;
    }
}