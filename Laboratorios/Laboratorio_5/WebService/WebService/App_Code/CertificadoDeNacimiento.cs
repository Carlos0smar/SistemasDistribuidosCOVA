using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de CertificadoDeNacimiento
/// </summary>
public class CertificadoDeNacimiento
{
    public string cedula_identidad;
    public string nombres;
    public string primer_apellido;
    public string segundo_apellido;
    public string fecha_nacimiento;
    public string nombre_padre;
    public string apellidos_padre;
    public string nombre_madre;
    public string apellidos_madre;

    public CertificadoDeNacimiento(string cedula_identidad, string nombres, string primer_apellido, string segundo_apellido, string fecha_nacimiento, string nombre_padre, string apellidos_padre, string nombre_madre, string apellidos_madre)
    {
        this.cedula_identidad = cedula_identidad;
        this.nombres = nombres;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nombre_padre = nombre_padre;
        this.apellidos_padre = apellidos_padre;
        this.nombre_madre = nombre_madre;
        this.apellidos_madre = apellidos_madre;
    }


    public CertificadoDeNacimiento()
    {
        this.cedula_identidad = "";
        this.nombres = "";
        this.primer_apellido = "";
        this.segundo_apellido = "";
        this.fecha_nacimiento = "";
        this.nombre_padre = "";
        this.apellidos_padre = "";
        this.nombre_madre = "";
        this.apellidos_madre = "";
    }
}