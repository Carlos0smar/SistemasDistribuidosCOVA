/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class RegistroAlumnos extends UnicastRemoteObject implements IRegistroAlumnos{

    ArrayList<Alumno> listaAlumnos;
    
    public RegistroAlumnos() throws RemoteException{
        super();
        this.listaAlumnos = new ArrayList<>();
    }
    @Override
    public Alumno registrarAlumno(Alumno alumno) throws RemoteException {
        this.listaAlumnos.add(alumno);
        return alumno;
    }

    @Override
    public ArrayList<Alumno> listarAlumnos() throws RemoteException {
       return listaAlumnos;
    }
}
