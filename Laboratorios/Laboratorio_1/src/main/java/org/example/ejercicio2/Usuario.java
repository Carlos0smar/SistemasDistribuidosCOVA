package org.example.ejercicio2;

import java.util.ArrayList;

public class Usuario {
    String name;
    String password;
    ArrayList<Contacto> contactos;




    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;

        this.contactos = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public void addContact(Contacto contacto){
        contactos.add(contacto);
    }

    public Contacto searchContact(String contacto){
        for(Contacto contactoFor : contactos ){
            if(contactoFor.getNombre().equals(contacto)){
                return contactoFor;
            }
        }
        return null;
    }

    public void removeContact(String contacto){

        for(Contacto contactoFor : contactos ){
            if(contactoFor.getNombre().equals(contacto)){
                contactos.remove(contactoFor);
                System.out.println("Contacto eliminado");
                return;
            }
        }



    }

}
