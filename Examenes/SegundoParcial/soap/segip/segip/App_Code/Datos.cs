using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de Datos
/// </summary>
public class Datos
{
    public string ci { get; set; }
    public string nombres { get; set; }
    public string primerApellido { get; set; }
    public string segundoApellido { get; set; }
    public Datos(string ci,string nombres,string  primerApellido, string segundoApellido)
    {
        this.ci = ci;
        this.nombres = nombres;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public Datos()
    {
     
    }
}