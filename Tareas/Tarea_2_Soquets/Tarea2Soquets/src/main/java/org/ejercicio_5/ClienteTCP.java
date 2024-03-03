package org.ejercicio_5;


import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;



/**
 *
 * @author Carlos
 */
public class ClienteTCP {
    private static final String DIRECTORIO = "D:\\UNIVERSIDAD\\7mo_Semestre\\SIS258_SistemasDistribuidos\\Assignments\\test_cliente_secondAssignment";

    public static void main(String[] args) {
        {
            Scanner sc=new Scanner(System.in);
            int port = 5002;

            try {
                Socket client = new Socket("localhost", port);


                PrintWriter toServer = new PrintWriter(client.getOutputStream(), true);
                BufferedReader fromServer = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));

                System.out.println("Upload a file:");
                String cadena=sc.nextLine();
                if (cadena.equals("enviar")) {
                    enviarArchivo(toServer, client);
                } else if (cadena.equals("solicitar")) {
                    solicitarArchivo(toServer, client.getInputStream());
                }
                toServer.println(cadena);
                String result = fromServer.readLine();
                System.out.println(result);


            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }


    private static void enviarArchivo(PrintWriter out, Socket toServer) throws IOException {
        // Solicitar al usuario el nombre del archivo que desea enviar
        System.out.println("Ingrese el nombre del archivo que desea enviar:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nombreArchivo = reader.readLine();

        // Enviar la solicitud al servidor
        out.println("enviar");

        // Enviar el nombre del archivo al servidor
        out.println(nombreArchivo);

        // Crear stream de entrada para leer el archivo
        FileInputStream fis = new FileInputStream(DIRECTORIO + File.separator + nombreArchivo);

        // Enviar el archivo al servidor
        byte[] buffer = new byte[4096];
        fis.read(buffer, 0, buffer.length);
        OutputStream os = toServer.getOutputStream();
        os.write(buffer, 0, buffer.length);


        // Cerrar streams
        fis.close();
        System.out.println("Archivo enviado correctamente: " + nombreArchivo);
    }

    private static void solicitarArchivo(PrintWriter toServer, InputStream in) throws IOException {

        toServer.println("solicitar");

        // Leer la respuesta del servidor (solicitud del nombre del archivo)
        BufferedReader inReader = new BufferedReader(new InputStreamReader(in));
        String mensaje = inReader.readLine();
        System.out.println(mensaje);

        // Leer el nombre del archivo del usuario
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nombreArchivo = reader.readLine();

        // Enviar el nombre del archivo al servidor
        toServer.println(nombreArchivo);

        // Crear stream de salida para escribir el archivo recibido
        FileOutputStream fos = new FileOutputStream(DIRECTORIO + File.separator + nombreArchivo);

        // Leer los bytes del archivo recibido y escribirlos en el archivo local
        byte[] buffer = new byte[4096];

        in.read(buffer, 0, buffer.length);
        fos.write(buffer, 0, buffer.length);


        // Cerrar streams
        fos.close();
        System.out.println("Archivo recibido correctamente: " + nombreArchivo);
    }
}
