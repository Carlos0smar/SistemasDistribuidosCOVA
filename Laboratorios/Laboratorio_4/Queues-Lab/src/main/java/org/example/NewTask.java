package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class NewTask {
    private static final DatabaseConection database = new DatabaseConection();
    private static final String TASK_QUEUE_NAME = "student_queue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

            String message = regitry();


            channel.basicPublish("", TASK_QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");

        }
    }

    public static String regitry(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter carnet de identidad:");
        String carnetDeIdentidad = scanner.nextLine();
        System.out.println("Enter nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Enter apellido:");
        String apellido = scanner.nextLine();
        System.out.println("Enter fecha de nacimiento (YYYY-MM-DD):");
        String fecha_nacimiento = scanner.nextLine();
        System.out.println("Enter carrera:");
        String carrera = scanner.nextLine();
        System.out.println("Enter ciudad:");
        String ciudad = scanner.nextLine();
        System.out.println("Enter direccion:");
        String direccion = scanner.nextLine();
        System.out.println("Enter correo:");
        String correo = scanner.nextLine();

        try {
            database.connect();

            // Preparar la consulta de inserción
            String insertQuery = "INSERT INTO ccbol_alumnos (carnet_de_identidad, nombre, apellido, fecha_nacimiento, carrera, ciudad, direccion, correo_electroniaco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = database.getConnection().prepareStatement(insertQuery)) {
                // Establecer los valores de los parámetros
                preparedStatement.setString(1, carnetDeIdentidad);
                preparedStatement.setString(2, nombre);
                preparedStatement.setString(3, apellido);
                preparedStatement.setDate(4, java.sql.Date.valueOf(fecha_nacimiento));
                preparedStatement.setString(5, carrera);
                preparedStatement.setString(6, ciudad);
                preparedStatement.setString(7, direccion);
                preparedStatement.setString(8, correo);

                // Ejecutar la inserción
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    return nombre+","+correo;
                } else {
                    return "No se pudo insertar el registro";
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "No se pudo insertar el registro";
    }

}