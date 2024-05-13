package com.tp2.main.model;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private int numeroCuenta;
    private String tipoCuenta;
    private LocalDate fechaCreacion;
    private double balance;
    private List<MovimientoCuenta> movimientosCuenta = new ArrayList<>();

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<MovimientoCuenta> getMovimientosCuenta() {
        return movimientosCuenta;
    }
}