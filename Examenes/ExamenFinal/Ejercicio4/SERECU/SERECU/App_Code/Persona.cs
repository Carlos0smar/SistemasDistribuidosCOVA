using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for Persona
/// </summary>
public class Persona
{
    private string _ci { get; set; }
    private string _nombres { get; set; }
    private string _primerApellido { get; set; }
    private string _segundoApellido { get; set; }
    private string _fechaNacimiento { get; set; }
    private string _sexo { get; set; }
    private string _estadoCivil { get; set; }

    public Persona(string ci, string nombres, string primerApellido, string segundoApellido, string fechaNacimiento, string sexo, string estadocivil)
    {
        _ci = ci;
        _nombres = nombres;
        _primerApellido = primerApellido;
        _segundoApellido = segundoApellido;
        _fechaNacimiento = fechaNacimiento;
        _sexo = sexo;
        _estadoCivil = estadocivil;

    }

    public Persona () { }
}