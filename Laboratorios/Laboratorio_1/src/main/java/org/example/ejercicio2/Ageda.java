package org.example.ejercicio2;


import java.util.ArrayList;
import java.util.Scanner;

public class Ageda {
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static boolean isRunning = true;

    public static void main(String[] args) {
        createUsuarios();
        Usuario usuario = userAuth();
        if (usuario != null){
            while (isRunning) {

                menu();
                System.out.println("Escoge una opcion");
                int option = scanner.nextInt();
                operaciones(option,usuario);

            }
        }

    }

    public static void operaciones(int operation, Usuario usuario) {
        String contac;
        switch (operation) {
            case 1:
                System.out.println("Introducir nombre: ");
                String nombre = scanner.next();
                System.out.println("Introducir numero: ");
                int telefono = scanner.nextInt();
                System.out.println("Introducir direccion: ");
                String direccion = scanner.next();

                Contacto contacoObject = new Contacto(nombre, telefono, direccion);
                usuario.addContact(contacoObject);
                break;
            case 2:
                System.out.println("Introducir el nombre: ");
                String nombrebuscar = scanner.next();
                showContactFound(usuario, nombrebuscar);
                break;
            case 3:
                System.out.println("Introducir el nombre a eliminar: ");
                String nombreEliminar = scanner.next();
                usuario.removeContact(nombreEliminar);
                break;
            case 4:
                isRunning = false;
                break;
            default:
                System.out.println("Escoja una opción válida");
                break;

        }
    }

    public static Usuario userAuth() {
        System.out.println("Introduzca usuario");
        String user = scanner.next();
        System.out.println("Contraseña");
        String password = scanner.next();
        for (Usuario usuario : usuarios) {
            if (usuario.getName().equals(user) && usuario.getPassword().equals(password)) {
                return usuario;
            }

        }
        System.out.println("Usuario o contrasena incorrecta");
        return null;
    }
    public static void menu() {
        System.out.println("1. Anadir contacto");
        System.out.println("2. buscar contacto");
        System.out.println("3. eliminar contacto");
        System.out.println("4. Salir de la agenda");

    }

    public static void showContactFound(Usuario usuario, String contacto){
        Contacto contactoFound = usuario.searchContact(contacto);
        if(contactoFound == null){
            System.out.println("Contacto no encontrado");
            return;
        }
        System.out.println("Nombre: " + contactoFound.getNombre());
        System.out.println("Numero: " + contactoFound.getNumero());
        System.out.println("Direccion: " + contactoFound.getDireccion());

    }
    public static void createUsuarios() {
        Usuario usuario1 = new Usuario("Carlos", "abc");
        Usuario usuario2 = new Usuario("Pedro", "def");
        Usuario usuario3 = new Usuario("Alejandro", "ghi");

        usuario1.getContactos().add(new Contacto("Pedro", 23434, "Daniel Campos" ));
        usuario2.getContactos().add(new Contacto("Miguel", 234376, "Lemoine" ));
        usuario3.getContactos().add(new Contacto("Pedro", 237654, "Loa" ));


        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

    }
}
