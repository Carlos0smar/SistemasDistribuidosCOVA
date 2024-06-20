package cova.assingment.thirdexercise;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;

public class MySqlConnection {




    Connection conn;

    public MySqlConnection() {
        Dotenv dotenv = Dotenv.load();

        String DB_URL = dotenv.get("DB_URL");
        String USER = dotenv.get("DB_USER");
        String PASS = dotenv.get("DB_PASS");

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
