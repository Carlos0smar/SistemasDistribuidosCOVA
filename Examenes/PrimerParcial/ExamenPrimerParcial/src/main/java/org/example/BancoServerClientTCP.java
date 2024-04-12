package org.example;
import org.example.Deuda;
import org.example.Impuesto;
import org.example.Ruat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import static java.lang.Integer.parseInt;

public class BancoServerClientTCP {
    static PrintStream toClient;
    static BufferedReader fromClient;

    public static void main(String[] args) {

        int port = 5002;
        ServerSocket server;
        try {
            while (true) {
                server = new ServerSocket(port);
                Socket client;
                client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
                fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                toClient = new PrintStream(client.getOutputStream());
                System.out.println("Cliente se conecto");

                String recibido = fromClient.readLine();

                toClient.println(protocolManagment(recibido));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }

    }


    static String protocolManagment(String recibido) throws MalformedURLException, NotBoundException, RemoteException {
        String[] protocolo = recibido.split(":");

        if(protocolo[0].equals("deuda")){
            return deudaManagment(protocolo[1]);
        }

        if(protocolo[1].equals("pagar")){
            return pagarManagment(protocolo[1]);
        }
        return recibido;
    }

    private static String pagarManagment(String pagarDeuda) throws MalformedURLException, NotBoundException, RemoteException {
        Ruat ruat = bancoCliente();
        Impuesto impuseto;
        String[] deudadDivided = pagarDeuda.split(",");
        if(deudadDivided[2].equals("vehiculo")){
            impuseto = Impuesto.vehiculo;
        } else {
            impuseto = Impuesto.inmueble;
        }

        Deuda deuda = new Deuda(deudadDivided[0], parseInt(deudadDivided[1]) , impuseto, Double.parseDouble(deudadDivided[3]));

        if(ruat.pagar(deuda)){
            return  "transaccion:true";
        } else {
            return "transaccion:false";
        }
    }

    public static String deudaManagment(String ci) throws MalformedURLException, NotBoundException, RemoteException {
        Ruat ruat = bancoCliente();
        Deuda[] deudas = ruat.buscar(ci);
        String deudasConcat = "";

        int i = 0;
        String deudasString = null;
        for (Deuda deuda : deudas) {
            i ++;

        }

        if(i == 0){
            return "deuda:"+deudas[0];
        }

        if(i == 1){
            return "deuda:"+deudas[0] + ";" + deudas[1];
        }


        return "deuda" + deudasString;
    }

    public static Ruat bancoCliente() throws MalformedURLException, NotBoundException, RemoteException {
        Ruat ruat = (Ruat) Naming.lookup("rmi://localhost/RUAT"); // instanciar un objeto remoto
        return ruat;
    }


}
