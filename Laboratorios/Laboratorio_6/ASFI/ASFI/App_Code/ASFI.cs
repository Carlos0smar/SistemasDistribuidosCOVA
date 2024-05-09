using BCPService;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Descripción breve de ASFI
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class ASFI : System.Web.Services.WebService
{

    public ASFI()
    {

        //Elimine la marca de comentario de la línea siguiente si utiliza los componentes diseñados 
        //InitializeComponent(); 
    }
    BCPService.BCPSoapClient bcpService = new BCPService.BCPSoapClient();
    MercantilService.MercantilSoapClient mercantilService = new MercantilService.MercantilSoapClient();


    [WebMethod]
    public Cuenta[] consultarCuentas(String ci, String nombres, String apellidos)
    {
        BCPService.Cuenta[] cuentasBcp = bcpService.buscar(ci, nombres, apellidos);
        MercantilService.Cuenta[] cuentasMercantil = mercantilService.buscar(ci, nombres, apellidos);

        if(cuentasBcp.Length == 1 && cuentasMercantil.Length == 1)
        {
            Cuenta[] allCuentas = new Cuenta[2];
            allCuentas[0] = cuentasBcp[0];
            //allCuentas[1] = cuentasMercantil[0];
            return allCuentas;

        }

        if (cuentasBcp.Length == 0 && cuentasMercantil.Length == 1)
        {
            Cuenta[] allCuentas = new Cuenta[1];
            //allCuentas[0] = cuentasMercantil[0];
            return allCuentas;

        }

        if (cuentasBcp.Length == 1 && cuentasMercantil.Length == 0)
        {
            Cuenta[] allCuentas = new Cuenta[1];
            allCuentas[0] = cuentasBcp[0];
            return allCuentas;

        }

        return null;

    }



    [WebMethod]
    public bool reternerMonto(String cuenta, Double monto)
    {
        Boolean isCongeladoBCP = bcpService.congelar(cuenta, monto);
        Boolean isCongeladoMercantil = mercantilService.congelar(cuenta, monto);

        if(isCongeladoBCP || isCongeladoMercantil)
        {
            return true;
        }
        return false;
    }

}
