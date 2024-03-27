/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author Carlos
 */
public class ServerMercantil {

    public static void main(String args[]) {
        int port = 6788;
        try {

            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];

            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion
                        = new DatagramPacket(bufer, bufer.length);

                // Leemos una petición del DatagramSocket
                socketUDP.receive(peticion);
                // lo recibido
                String cadena = new String(peticion.getData(), 0, peticion.getLength());

                String response =procesarProtocolo(cadena);
                byte[] mensaje = response.getBytes();

                DatagramPacket respuesta
                        = new DatagramPacket(mensaje, response.length(),
                        peticion.getAddress(), peticion.getPort());

                // Enviamos la respuesta, que es un eco
                socketUDP.send(respuesta);
            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    public static String procesarProtocolo(String solicitud) {
        String[] comandos = solicitud.split(":");

        if(comandos[0].equals("Buscar")){
            return buscarCuentas(comandos[1]);
        }

        if(comandos[0].equals("Congelar")){
            return retenerMonto(comandos[1]);
        }

        return "no:encontrado";
    }

    public static String buscarCuentas(String solicitud) {
        String cuentas = "";
        String[] datos = solicitud.split("-");


        if (datos[0].equals("7687682") && datos[1].equals("Juan") && datos[2].equals("Segovia")) {

            cuentas = "1112450-5000";
            return cuentas;
        }

        if (datos[0].equals("54654") && datos[1].equals("Maria") && datos[2].equals("Parra")) {
            cuentas = "1121454-300";
            return cuentas;
        }

        return "no:encontrado";
    }

    public static String retenerMonto(String solicitud) {
        String[] datos = solicitud.split("-");

        if (datos[0].equals("1112450") && Integer.parseInt(datos[1])<=5000) {
            return "Si-1112450";
        }

        if (datos[0].equals("1121454") && Integer.parseInt(datos[1]) <= 300) {
            return "Si-1121454";
        }

        return "no-noencontrado";
    }

}
