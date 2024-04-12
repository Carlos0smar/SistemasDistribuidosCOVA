package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

public class Ruat extends UnicastRemoteObject implements IRuat {
    public Ruat() throws RemoteException {
        super();
    }
    @Override
    public Deuda[] buscar(String ci) throws RemoteException {
        Deuda[] invalid = null;
        if(ci.equals("1234567")){
            Deuda[] deudas = new Deuda[2];

            deudas[0] = new Deuda("1234567", 2022, Impuesto.vehiculo, 2451);
            deudas[1] = new Deuda("1234567", 2022, Impuesto.inmueble, 2500);
            return deudas;
        }

        if(ci.equals("555587")){
            Deuda[] deudas = new Deuda[1];

            deudas[1] = new Deuda("555587", 2021, Impuesto.vehiculo, 5000);
            return deudas;

        }

        if(ci.equals("333357")){
            Deuda[] deudas = new Deuda[1];

            deudas[1] = new Deuda("333357", 2023, Impuesto.inmueble, 24547);
            return deudas;
        }
        return invalid;
    }



    @Override
    public Boolean pagar(Deuda deuda) throws RemoteException {
        return AlcaldiaUDP(deuda.getCi());
    }
    public boolean AlcaldiaUDP(String ci){

        try {
            int puertoMercantil = 6788;

            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = ci.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion
                    = new DatagramPacket(mensaje, ci.length(), hostServidor,
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
            if (comandos[0].equals("respuesta")) {
                if(comandos[1].equals("true")){
                    return true;
                } else {
                    return false;
                }
            }

            // Cerramos el socket
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        return false;
    }
}
