package org.example.ejercicio1;

public class Usuario {
    String name;
    String password;
    Cuenta cuenta;



    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
        this.cuenta = new Cuenta();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
