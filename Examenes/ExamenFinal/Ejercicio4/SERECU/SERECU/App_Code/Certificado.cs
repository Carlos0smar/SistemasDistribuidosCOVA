using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for Certificado
/// </summary>
public class Certificado
{
    private string _ci;
    private string _nombres { get; set; }
    private string _primerApellido { get; set; }
    private string _segundoApellido { get; set; }
    private string _fechaNacimiento { get; set; }
    private string _nombrePadre { get; set; }
    private string _apellidoPadre { get; set; }
    private string _nombreMadre { get; set; }
    private string _apellidoMadre{ get; set; }


    public Certificado(string ci, string nombres, string primerApellido, string segundoApellido, string fechaNacimiento, string nombrePadre, string apellidoPadre, string nombreMadre, string apellidoMadre)
    {
        _ci = ci;
        _nombres = nombres;
        _primerApellido = primerApellido;
        _segundoApellido = segundoApellido;
        _fechaNacimiento = fechaNacimiento;
        _apellidoMadre = apellidoMadre;
        _nombreMadre = nombreMadre;
        _apellidoPadre = apellidoPadre;
        _nombrePadre = nombrePadre;

    }

    public Certificado() { }
}