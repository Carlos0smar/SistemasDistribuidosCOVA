package org.example.ejercicio2;

public class Contacto {
    String nombre;
    int numero;
    String direccion;

    public Contacto(String nombre, int numero, String direccio) {
        this.nombre = nombre;
        this.numero = numero;
        this.direccion = direccio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
