package org.example;

import java.io.Serializable;

public class Empresa implements Serializable {
    private String nombre;
    private Long Nit;

    public Empresa(String nombre, Long nit) {
        this.nombre = nombre;
        Nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNit() {
        return Nit;
    }

    public void setNit(Long nit) {
        Nit = nit;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", Nit='" + Nit + '\'' +
                '}';
    }
}
