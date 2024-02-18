package cova.assingment.thirdexercise;
import java.sql.*;
public class MySqlConnection {

    String DB_URL = "jdbc:mysql://localhost/db_library";
    String USER = "root";
    String PASS = "";

    Connection conn;

    public MySqlConnection() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTables() {
        try (Statement stmt = conn.createStatement()) {
            // Create if not exists
            stmt.executeUpdate(Schema.CREATE_TABLE_BOOKSHELVE);
            stmt.executeUpdate(Schema.CREATE_TABLE_BOOK);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
