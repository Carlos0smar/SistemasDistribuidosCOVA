using ServiceReferenceSerecu;

namespace WinFormsAppObjetos
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string ci = textBox1.Text;

            ServiceReferenceSerecu.SerecuWebServiceSoapClient cliente = new ServiceReferenceSerecu.SerecuWebServiceSoapClient(new ServiceReferenceSerecu.SerecuWebServiceSoapClient.EndpointConfiguration());


            string content = "";
            switch (comboBox1.SelectedIndex)
            {
                case 0:
                    Persona persona = cliente.ObtenerDatos(ci);
                    content = persona.celula_identidad + ", " + persona.nombres + ", " + persona.primer_apellido + ", " + persona.segundo_apellido + ", " + persona.fecha_nacimiento + ", " + persona.estado_civil;
                    break;
                case 1:
                    CertificadoDeNacimiento certificado_nacimiento = cliente.ObtenerCertificadoDeNacimiento(ci);
                    content = certificado_nacimiento.nombres + ", " + certificado_nacimiento.primer_apellido + ", " + certificado_nacimiento.segundo_apellido + ", " + certificado_nacimiento.fecha_nacimiento + ", " + certificado_nacimiento.nombre_padre + ", " + certificado_nacimiento.apellidos_padre + ", " + certificado_nacimiento.nombre_madre + ", " + certificado_nacimiento.apellidos_madre;
                    break;
                case 2:
                    certificadoMatrimonio certificado_matrimonio = cliente.ObtenerCertificadoDeMatrimonio(ci);
                    content = certificado_matrimonio.cedula_identidad_esposo + ", " + certificado_matrimonio.nombre_esposo + ", " + certificado_matrimonio.primerapellido_esposo + ", " + certificado_matrimonio.segundoapellido_esposo + ", " + certificado_matrimonio.cedula_identidad_esposa + ", " + certificado_matrimonio.nombre_esposa + ", " + certificado_matrimonio.primerapellido_esposa + ", " + certificado_matrimonio.segundoapellido_esposa; break;
                case 3:
                    CertificadoDefuncion certificado_defuncion = cliente.ObtenerCertificadoDeDefuncion(ci);
                    content = certificado_defuncion.cedula_identidad + ", " + certificado_defuncion.nombres + ", " + certificado_defuncion.primer_apellido + ", " + certificado_defuncion.segundo_apellido + ", " + certificado_defuncion.fecha_defuncion + ", " + certificado_defuncion.causa;
                    break;
                default:
                    break;

            }
            label1.Text = content.ToString();

        }

    }
}