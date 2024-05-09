using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de Persona
/// </summary>
public class Persona
{
    public String celula_identidad;
    public String nombres;
    public String primer_apellido;
    public String segundo_apellido;
    public String fecha_nacimiento;
    public String sexo;
    public String estado_civil;

    public Persona(string celula_identidad, string nombres, string primer_apellido, string segundo_apellido, string fecha_nacimiento, string sexo, string estado_civil)
    {
        this.celula_identidad = celula_identidad;
        this.nombres = nombres;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.estado_civil = estado_civil;
    }

    public Persona()
    {
        this.celula_identidad = "";
        this.nombres = "";
        this.primer_apellido = "";
        this.segundo_apellido = "";
        this.fecha_nacimiento = "";
        this.sexo = "";
        this.estado_civil = "";
    }



}