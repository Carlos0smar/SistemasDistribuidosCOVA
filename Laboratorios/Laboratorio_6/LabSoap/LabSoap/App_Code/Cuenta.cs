using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de Cuenta
/// </summary>
public class Cuenta
{
    public Enum banco;
    public String ci;
    public String nroCuenta;
    public String nombres;
    public String apellidos;
    public Double saldo;
    public Cuenta(Enum banco,String ci, String nombres, String apellidos, String nroCuenta, Double saldo)
    {
        this.banco = banco;
        this.ci = ci;
        this.nroCuenta = nroCuenta;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.saldo = saldo;
    }

    public Cuenta()
    {
    }
}

public enum Banco
{
    Mercantil,BCP
}