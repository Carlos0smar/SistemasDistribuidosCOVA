using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Descripción breve de BCP
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class BCP : System.Web.Services.WebService
{

    public BCP()
    {

        //Elimine la marca de comentario de la línea siguiente si utiliza los componentes diseñados 
        //InitializeComponent(); 
    }

    [WebMethod]
    public Cuenta[] buscar(String ci, String nombres, String apellidos)
    {
        Cuenta[] cuentas = new Cuenta[1];
        if(ci == "7687682" &&  nombres == "Juan" &&  apellidos == "Segovia")
        {
            cuentas[0] = new Cuenta(Banco.BCP, "7687682", "Juan", "Segovia", "6657654", 2000);
        }

        if (ci == "455787" && nombres == "Ricardo" && apellidos == "Centellas")
        {
            cuentas[1] = new Cuenta(Banco.BCP, "455787", "Ricardo", "Centellas", "657255", 5890);
        }
        return cuentas;
    }

    


    [WebMethod]
    public Boolean congelar(String cuenta, Double monto)
    {
        
        if (cuenta == "6657654" && monto<= 2000)
        {
            return true;
        }

        if (cuenta == "657255" && monto <= 5890)
        {
            return true;

        }
        return false;

    }



}
