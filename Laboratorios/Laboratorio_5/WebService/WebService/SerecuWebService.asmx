<%@ WebService Language="C#" Class="SerecuWebService" %>

using System;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;




[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
[System.Web.Script.Services .ScriptService]
public class SerecuWebService  : System.Web.Services.WebService {

    [WebMethod]
    public Persona ObtenerDatos(string cedula_identidad) {

        Persona[] personas = crearPersonas();

        for(int i = 0; i<= 3; i++)
        {
            if(personas[i].celula_identidad == cedula_identidad)
            {
                return personas[i];
            }
        }

        return null;

    }

    private Persona[] crearPersonas()
    {
        Persona[] personas = new Persona[3];

        personas[0] = new Persona("1234", "jose", "Rojas", "Arispe", "07/05/2003", "Masculino", "casado");
        personas[1] = new Persona("5678", "Aracely", "Mamani", "Zambrana", "01/04/2003", "Femenino", "casado");
        personas[2] = new Persona("1357", "Miguel", "Arispe", "Rivera", "08/01/2003", "Masculino", "casado");

        return personas;
    }


    [WebMethod]
    public CertificadoDeNacimiento ObtenerCertificadoDeNacimiento(string cedula_identidad) {

        CertificadoDeNacimiento[] certificados = crearCertificadoDeNacimiento();

        for(int i = 0; i<= 3; i++)
        {
            if(certificados[i].cedula_identidad == cedula_identidad)
            {
                return certificados[i];
            }
        }

        return null;

    }

    private CertificadoDeNacimiento[] crearCertificadoDeNacimiento()
    {
        CertificadoDeNacimiento[] certificados = new CertificadoDeNacimiento[3];

        certificados[0] = new CertificadoDeNacimiento("1234", "jose", "Arispe", "Rojas", "05/06/2003", "Pedro", "Ramirez", "Maria", "Otondo");
        certificados[1] = new CertificadoDeNacimiento("5678", "Miguel", "Coronado", "Rojas", "07/02/2005", "Carlos", "Gonzales", "Paty", "Otondo");
        certificados[2] = new CertificadoDeNacimiento("1357", "Marta", "Arispe", "Rojas", "30/07/2002", "Alejandro", "Ramirez", "Andrea", "Rojas");
       
        return certificados;
    }


    [WebMethod]
    public certificadoMatrimonio ObtenerCertificadoDeMatrimonio(string cedula_identidad) {

        certificadoMatrimonio[] certificados = crearCertificadoDeMatrimonio();

        for(int i = 0; i<= 2; i++)
        {
            if(certificados[i].cedula_identidad == cedula_identidad)
            {
                return certificados[i];
            }
        }

        return null;

    }

    private certificadoMatrimonio[] crearCertificadoDeMatrimonio()
    {
        certificadoMatrimonio[] certificados = new certificadoMatrimonio[2];

        certificados[0] = new certificadoMatrimonio("1234", "2844", "jose", "Arispe", "Rojas", "32443", "Maria", "Mamani", "Alvis" );
        certificados[1] = new certificadoMatrimonio("3243", "6576", "Pedro", "Coronado", "Mamani", "3454", "Marta", "Quispe", "Gonzales" );

        return certificados;
    }

    [WebMethod]
    public CertificadoDefuncion ObtenerCertificadoDeDefuncion(string cedula_identidad) {

        CertificadoDefuncion[] certificados = crearCertificadoDeDefuncion();

        for(int i = 0; i<= 2; i++)
        {
            if(certificados[i].cedula_identidad == cedula_identidad)
            {
                return certificados[i];
            }
        }

        return null;

    }

    private CertificadoDefuncion[] crearCertificadoDeDefuncion()
    {
        CertificadoDefuncion[] certificados = new CertificadoDefuncion[2];

        certificados[0] = new CertificadoDefuncion("1234", "Miguel", "Rojas", "Arispe", "24/05/1997", "covid19");
        certificados[1] = new CertificadoDefuncion("2343", "Pedro", "Otondo", "Coronado", "04/01/1994", "covid19");
             

        return certificados;
    }




}