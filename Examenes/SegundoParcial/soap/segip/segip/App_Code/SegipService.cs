using System;
using System.Collections.Generic;
using System.Drawing.Printing;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Descripción breve de SegipService
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class SegipService : System.Web.Services.WebService
{

    public SegipService()
    {

        //Elimine la marca de comentario de la línea siguiente si utiliza los componentes diseñados 
        //InitializeComponent(); 
    }

    [WebMethod]
    public bool VerificarDatos(string ci, string nombres, string primerApellido, string segundoApellido)
    {

        Datos dato1 = new Datos("12344", "Juan", "Rojas", "Arispe");
        Datos dato2 = new Datos("4554", "pedro", "Quispe", "Mamani");

        if(ci == dato1.ci & nombres == dato1.nombres & primerApellido == dato1.primerApellido & segundoApellido == dato1.segundoApellido)
        {
            return true;

        }

        if (ci == dato2.ci & nombres == dato2.nombres & primerApellido == dato2.primerApellido & segundoApellido == dato2.segundoApellido)
        {
            return true;

        }
        return false;
    }

    [WebMethod]
    public Datos obtenerDatos(string ci)
    {
        Datos dato1 = new Datos("12344", "Juan", "Rojas", "Arispe");
        Datos dato2 = new Datos("4554", "pedro", "Quispe", "Mamani");

        if (ci == dato1.ci)
        {
            return dato1;
        }
        if (ci == dato2.ci)
        {
            return dato2;
        }

        return null;
    }
}
