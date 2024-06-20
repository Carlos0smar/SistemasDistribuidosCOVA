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
        String sql = "INSERT INTO book (title, author, editorial, year, id_book_shelve) VALUES (?, ?, ?, ?, ?)";
        String sqlSelect = "SELECT id FROM book_shelve WHERE code = ?";
        try (PreparedStatement pstmt = mySqlConnection.conn.prepareStatement(sql);
             PreparedStatement pstmtSelect = mySqlConnection.conn.prepareStatement(sqlSelect)) {

            pstmtSelect.setString(1, codeBookShelve);
            try (ResultSet rs = pstmtSelect.executeQuery()) {
                if (rs.next()) {
                    int idBookShelve = rs.getInt("id");

                    pstmt.setString(1, bookTitle);
                    pstmt.setString(2, authorBook);
                    pstmt.setString(3, editorial);
                    pstmt.setInt(4, year);
                    pstmt.setInt(5, idBookShelve);

                    pstmt.executeUpdate();
                } else {
                    System.out.println("No se encontró el estante de libros con el código proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showLibrary() {
        showBookShelves();
        showBooks();
    }

    private void showBookShelves() {
        String sql = "SELECT * FROM book_shelve";


        try (Statement stmt = mySqlConnection.conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Code: " + rs.getString("code") + ", Material type: " + rs.getString("material_type"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showBooks() {

        String sql = "SELECT bs.*, b.* FROM book_shelve as bs INNER JOIN book as b ON bs.id = b.id_book_shelve";

        try (Statement stmt = mySqlConnection.conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Title: " + rs.getString("title") + ", Author: " + rs.getString("author") + ", Editorial: " + rs.getString("editorial") + ", Year: " + rs.getInt("year") + ", Code book shelve: " + rs.getString("code"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ResultSet getBookShelveFromDatabase(String code) {
        String sql = "SELECT id FROM book_shelve WHERE code = ?";
        try (PreparedStatement pstmt = mySqlConnection.conn.prepareStatement(sql)) {
            pstmt.setString(1, code);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
