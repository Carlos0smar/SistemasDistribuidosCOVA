package cova.assingment.thirdexercise;
import cova.assingment.secondexercise.TypeBookShelves;

import java.sql.*;


public class DatabaseManager {

    private static MySqlConnection mySqlConnection;

    public DatabaseManager() {
        this.mySqlConnection = new MySqlConnection();
    }

    public void saveBookShelve(String code, TypeBookShelves materialType) {
        String sql = "INSERT INTO book_shelve (code, material_type) VALUES (?,?)";
        try (PreparedStatement pstmt = mySqlConnection.conn.prepareStatement(sql)) {
            pstmt.setString(1, code);
            pstmt.setString(2, materialType.name());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveBook(String bookTitle, String authorBook, int year, String editorial, String codeBookShelve) {
        String sql = "INSERT INTO book (title, author, editorial, year, code_book_shelve) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = mySqlConnection.conn.prepareStatement(sql)) {
            pstmt.setString(1, bookTitle);
            pstmt.setString(2, authorBook);
            pstmt.setString(3, editorial);
            pstmt.setInt(4, year);
            pstmt.setString(5, codeBookShelve);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
