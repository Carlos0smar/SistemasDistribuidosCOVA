package org.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class AlcaldiaServerUDP {
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

    public static String procesarProtocolo(String respuesta){
        String[] protocolo = respuesta.split(":");
        if(protocolo[1].equals("1234567")){
            return "respuesta:true";
        } else {
            return "respuesta:false";

        }
    }
}
