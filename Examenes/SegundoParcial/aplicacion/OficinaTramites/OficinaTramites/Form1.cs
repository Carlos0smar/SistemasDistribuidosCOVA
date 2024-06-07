namespace OficinaTramites
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private async void button1_Click(object sender, EventArgs e)
        {
            servicioSegip.SegipServiceSoapClient clienteSegip = new servicioSegip.SegipServiceSoapClient(new servicioSegip.SegipServiceSoapClient.EndpointConfiguration());


            string url = "http://127.0.0.1:8000/api/v1/titulo";
            String resultado = await GetDataFromApiAsync(url);

            string ci = textBox1.Text.ToString();
            string nombres = textBox2.Text.ToString();
            string primerApellido = textBox3.Text.ToString();
            string segundoApellido = textBox4.Text.ToString();
            string titulo = textBox5.Text.ToString();

            if(clienteSegip.VerificarDatos(ci, nombres, primerApellido, segundoApellido))
            {

            }

        }

        private async Task<string> GetDataFromApiAsync(string url)
        {
            using (HttpClient client = new HttpClient())
            {
                try
                {
                    HttpResponseMessage response = await client.GetAsync(url);
                    response.EnsureSuccessStatusCode();
                    string responseBody = await response.Content.ReadAsStringAsync();
                    return responseBody;
                }
                catch (HttpRequestException ex)
                {
                    return $"Error: {ex.Message}";
                }
            }
        }
}