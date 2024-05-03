using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Descripción breve de Mercantil
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class Mercantil : System.Web.Services.WebService
{

    public Mercantil()
    {

        //Elimine la marca de comentario de la línea siguiente si utiliza los componentes diseñados 
        //InitializeComponent(); 
    }


    [WebMethod]
    public Cuenta[] buscar(String ci, String nombres, String apellidos)
    {
        Cuenta[] cuentas = new Cuenta[1];
        if (ci == "7687682" && nombres == "Juan" && apellidos == "Segovia")
        {
            cuentas[0] = new Cuenta(Banco.BCP, "7687682", "Juan", "Segovia", "1112450", 50000);
        }

        if (ci == "54654" && nombres == "Maria" && apellidos == "Parra")
        {
            cuentas[1] = new Cuenta(Banco.BCP, "54654", "Maria", "Parra", "1121454", 3000);
        }
        return cuentas;
    }




    [WebMethod]
    public bool congelar(String cuenta, Double monto)
    {

        if (cuenta == "1112450" && monto <= 50000)
        {
            return true;
        }

        if (cuenta == "1121454" && monto <= 3000)
        {
            return true;

        }
        return false;

    }


}
