package cova.assingment.thirdexercise;

public class Schema {
    public static final String CREATE_TABLE_BOOKSHELVE =
            "CREATE TABLE IF NOT EXISTS book_shelve (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "code VARCHAR(50)," +
                    "material_type VARCHAR(255)" +
                    ")";

    public static final String CREATE_TABLE_BOOK =
            "CREATE TABLE IF NOT EXISTS book (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "title VARCHAR(255)," +
                    "author VARCHAR(255)," +
                    "editorial VARCHAR(255)," +
                    "year YEAR," +
                    "code_book_shelve VARCHAR(50)" +
                    ")";
}