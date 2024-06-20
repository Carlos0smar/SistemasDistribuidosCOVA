using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Summary description for WebService
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class WebService : System.Web.Services.WebService
{

    public WebService()
    {

        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
    }

    [WebMethod]
    public Persona ObtenerDatos(string ci)
    {
        switch (ci)
        {
            case "12345":
                Persona persona1 = new Persona("12345", "Alejandro", "Arispe",  "Quispe", "12/05/2000","M", "Casado");
                return persona1;
            case "23456":
                Persona persona2 = new Persona("23456", "Mguel", "Mamani", "Ordoñez", "18/02/2000", "M", "Casado");
                return persona2;
            case "34567":
                Persona persona3 = new Persona("34567", "Walter", "Rojas", "Chocamani", "22/05/2000", "M", "Casado");
                return persona3;
            case "56789":
                Persona persona4 = new Persona("56789", "Jose", "Chocamani", "Quispe", "02/05/2000", "M", "Casado");
                return persona4;
            default:
            return null;
        }
        
      
    }


    [WebMethod]
    public Certificado ObtenerCertificado(string ci)
    {
        switch (ci)
        {
            case "12345":
                return new Certificado("12345", "Alejandro", "Arispe", "Quispe", "12/05/2000", "Jose", "Arispe", "Maria", "Quispe");
            case "23456":
                return new Certificado("23456", "Mguel", "Mamani", "Ordoñez", "18/02/2000", "Pedro", "Mamani", "Josefina", "Ordoñez");
            case "34567":
                return new Certificado("34567", "Walter", "Rojas", "Chocamani", "22/05/2000", "Justo", "Rojas", "David", "Chocamani");
            case "56789":
                return new Certificado("56789", "Jose", "Chocamani", "Quispe", "02/05/2000", "Ricardo", "Chocamani", "Alejandra", "Quispe");
            default:
                return null;
        }


    }

}
