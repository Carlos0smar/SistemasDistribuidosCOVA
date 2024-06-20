package org.example;

import java.io.Serializable;

public class Factura implements Serializable {
    Empresa empresa;
    int idFactura;
    Mes mes;
    int anio;
    double monto;

    public Factura(Empresa empresa, int idFactura, Mes mes, int anio, double monto) {
        this.empresa = empresa;
        this.idFactura = idFactura;
        this.mes = mes;
        this.anio = anio;
        this.monto = monto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "empresa=" + empresa +
                ", idFactura=" + idFactura +
                ", mes=" + mes +
                ", anio=" + anio +
                ", monto=" + monto +
                '}';
    }
}
