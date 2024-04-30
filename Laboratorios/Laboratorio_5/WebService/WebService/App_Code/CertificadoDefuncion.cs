using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de CertificadoDefuncion
/// </summary>
public class CertificadoDefuncion
{
    public string cedula_identidad;
    public string nombres;
    public string primer_apellido;
    public string segundo_apellido;
    public string fecha_defuncion;
    public string causa;


    public CertificadoDefuncion(string cedula_identidad, string nombres, string primer_apellido, string segundo_apellido, string fecha_defuncion, string causa)
    {
        this.cedula_identidad = cedula_identidad;
        this.nombres = nombres;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.fecha_defuncion = fecha_defuncion;
        this.causa = causa;
    }

    public CertificadoDefuncion()
    {
        this.cedula_identidad = "";
        this.nombres = "";
        this.primer_apellido = "";
        this.segundo_apellido = "";
        this.fecha_defuncion = "";
        this.causa = "";
    }
}