package com.tp2.main.model;

public class MovimientoCuenta {
    /*en esta clase estaran estructurados los movimientos de cuenta de cada cuenta*/
    private String hora;
    private String fecha;
    private String tipoOperacion;
    private double monto;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion){
        this.tipoOperacion = tipoOperacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto){
        this.monto = monto;
    }
}
