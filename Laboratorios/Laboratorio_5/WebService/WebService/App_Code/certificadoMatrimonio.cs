using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de certificadoMatrimonio
/// </summary>
public class certificadoMatrimonio
{
    public String cedula_identidad;
    public String cedula_identidad_esposo;
    public String nombre_esposo;
    public String primerapellido_esposo;
    public String segundoapellido_esposo;
    public String cedula_identidad_esposa;
    public String nombre_esposa;
    public String primerapellido_esposa;
    public String segundoapellido_esposa;

    //public String cedula_identidad_esposo;

    public certificadoMatrimonio(string cedula_identidad, string cedula_identidad_esposo, string nombre_esposo, string primerapellido_esposo, string segundoapellido_esposo, string cedula_identidad_esposa, string nombre_esposa, string primerapellido_esposa, string segundoapellido_esposa)
    {
        this.cedula_identidad = cedula_identidad;
        this.cedula_identidad_esposo = cedula_identidad_esposo;
        this.nombre_esposo = nombre_esposo;
        this.primerapellido_esposo = primerapellido_esposo;
        this.segundoapellido_esposo = segundoapellido_esposo;
        this.cedula_identidad_esposa = cedula_identidad_esposa;
        this.nombre_esposa = nombre_esposa;
        this.primerapellido_esposa = primerapellido_esposa;
        this.segundoapellido_esposa = segundoapellido_esposa;
    }

    public certificadoMatrimonio()
    {
        this.cedula_identidad = "";
        this.cedula_identidad_esposo = "";
        this.nombre_esposo = "";
        this.primerapellido_esposo = "";
        this.segundoapellido_esposo = "";
        this.cedula_identidad_esposa = "";
        this.nombre_esposa = "";
        this.primerapellido_esposa = "";
        this.segundoapellido_esposa = "";
    }
}