/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Carlos
 */
public class Asfi extends UnicastRemoteObject implements IAsfi {

    public Asfi() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Cuenta> ConsultarCuentas(String ci, String nombres, String apellidos) throws RemoteException {
        ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
        cuentas.addAll(ClienteBCPTcp(ci, nombres, apellidos));
        cuentas.addAll(ClienteMercantilUdp(ci, nombres, apellidos));
        return cuentas;
    }

    public ArrayList<Cuenta> ClienteBCPTcp(String ci, String nombres, String apellidos) {

        ArrayList<Cuenta> auxiliar = new ArrayList<Cuenta>();

        int port = 5002;
        try {
            Socket client = new Socket("localhost", port);

            String dato = "Buscar:" + ci + "-" + nombres + "-" + apellidos;

            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

            toServer.println(dato);

            String result = fromServer.readLine();

            String[] comandos = result.toString().split(":");
            if (!comandos[0].equals("no")) {
                String[] datosCuenta = comandos[0].split("-");
                Cuenta cuentaMercantil = new Cuenta(Banco.BCP, datosCuenta[0], ci, nombres, apellidos, Double.parseDouble(datosCuenta[1]));
                auxiliar.add(cuentaMercantil);
            }


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return auxiliar;
    }

    public ArrayList<Cuenta> ClienteMercantilUdp(String ci, String nombres, String apellidos) {
        // Se vuelve cliente del ban mercantil para obtener sus cuentas
        ArrayList<Cuenta> auxiliar = new ArrayList<Cuenta>();
        try {
            int puertoMercantil = 6788;
            String dato = "Buscar:" + ci + "-" + nombres + "-" + apellidos;
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = dato.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion
                    = new DatagramPacket(mensaje, dato.length(), hostServidor,
                    puertoMercantil);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta
                    = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta);

            // Convertimos los datos del paquete a String
            String respuestaStr = new String(respuesta.getData(), 0, respuesta.getLength());


            // Enviamos la respuesta del servidor a la salida estandar
            String[] comandos = respuestaStr.split(":");
            if (!comandos[0].equals("no")) {
                String[] datosCuenta = comandos[0].split("-");
                Cuenta cuentaMercantil = new Cuenta(Banco.Mercantil, datosCuenta[0], ci, nombres, apellidos, Double.parseDouble(datosCuenta[1]));
                auxiliar.add(cuentaMercantil);
            }

            // Cerramos el socket
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }

        return auxiliar;
    }

    @Override
    public Boolean RetenerMonto(Cuenta cuenta, int montoBs, String glosa) throws RemoteException {
        if (cuenta.getBanco() == Banco.BCP) {
            return ClienteBCPTcpRetener(cuenta, montoBs, glosa);
        } else {
            return ClienteMercantilUdpRetener(cuenta, montoBs, glosa);
        }
    }

    public Boolean ClienteBCPTcpRetener(Cuenta cuenta, int montoBs, String glosa) {
        try {
            int port = 5002;
            Socket client = new Socket("localhost", port);

            String dato = "Congelar:" + cuenta.getNrocuenta() + "-" + montoBs + "-" + glosa;

            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

            toServer.println(dato);

            String result = fromServer.readLine();
            String[] cadena = result.split("-");

            return cadena[0].equals("Si");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;

    }

    public Boolean ClienteMercantilUdpRetener(Cuenta cuenta, int montoBs, String glosa) {
        try {
            int puertoMercantil = 6788;
            String dato = "Congelar:" + cuenta.getNrocuenta() + "-" + montoBs;
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = dato.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion
                    = new DatagramPacket(mensaje, dato.length(), hostServidor,
                    puertoMercantil);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta
                    = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta);

            // Convertimos los datos del paquete a String
            String respuestaStr = new String(respuesta.getData(), 0, respuesta.getLength());

            String[] cadena = respuestaStr.split("-");

            return cadena[0].equals("Si");
            // Cerramos el socket

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        return false;
    }

}
