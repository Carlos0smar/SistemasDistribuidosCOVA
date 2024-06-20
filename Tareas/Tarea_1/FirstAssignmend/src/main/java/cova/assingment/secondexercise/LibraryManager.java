package cova.assingment.secondexercise;
import cova.assingment.thirdexercise.DatabaseManager;

import java.util.Scanner;

public class LibraryManager {
    static boolean isRunning = true;
    static Scanner sc = new Scanner(System.in);

    static Library library = new Library("Library", 100.0);

    public static void main(String[] args) {
        while (isRunning) {
            System.out.println("Welcome to the Library Management System");
            menu();
            int option = new Scanner(System.in).nextInt();
            options(option);
        }
    }

    public static void menu() {
        System.out.println("1. Create a BookShelve");
        System.out.println("2. Create a Book");
        System.out.println("3. List all books");
        System.out.println("4. List all bookshelves");
        System.out.println("5. remove book");
        System.out.println("6. remove bookshelve");
        System.out.println("7. Save in database");
        System.out.println("8. Show Library");
        System.out.println("9. Exit");
    }

    public static void options(int option) {

        switch (option) {
            case 1:
                createBookShelve();
                break;
            case 2:
                creteABook();
                break;
            case 3:
                listAllBooks();
                break;
            case 4:
                library.printBookShelves();
                break;
            case 5:
                searchBookShelveForDeleteBook();
                break;
            case 6:
                deleteBookShelve();
                break;
            case 7:
                saveInDatabase();
                break;
            case 8:
                showLibrary();
                break;
            case 9:
                isRunning = false;
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }


    public static void createBookShelve() {
        System.out.println("Enter the type of the bookshelve");

        System.out.println("1. Metallic");
        System.out.println("2. Wooden");

        int typeInput = sc.nextInt();
        TypeBookShelves typeBookShelves;

        if (typeInput == 1) {
            typeBookShelves = TypeBookShelves.Metallic;
        } else {
            typeBookShelves = TypeBookShelves.Wooden;
        }

        System.out.println("Enter the code of the bookshelve");

        String code = sc.next();

        BookShelve bookShelve = new BookShelve(typeBookShelves, code);

        library.addBookShelves(bookShelve);

    }

    public static void creteABook() {
        System.out.println("Enter the title of the book");
        String title = sc.next();
        System.out.println("Enter the author of the book");
        String author = sc.next();
        System.out.println("Enter the editorial of the book");
        String editorial = sc.next();
        System.out.println("Enter the year of the book");
        int year = sc.nextInt();

        Book book = new Book(title, author, editorial, year);

        System.out.println("Choose the bookshelve by code, to insert the book");

        library.printBookShelves();
        String code = sc.next();

        BookShelve bookShelve = library.getBookShelve(code);

        if (bookShelve != null) {
            bookShelve.addBook(book);
        } else {
            System.out.println("BookShelve not found");
        }
    }

    public static void searchBookShelveForDeleteBook(){

        System.out.println("Insert code of the BookShelve");
        library.printBookShelves();
        System.out.print("Code bookshelve: ");
        String codeBookShelve = sc.next();

        for (BookShelve bookShelve : library.getListBookShelves()){
            if(bookShelve.getCode().equals(codeBookShelve)){
                deleteBook(bookShelve);
            }
        }

    }



    public static void deleteBook(BookShelve bookShelve){
        System.out.println("Insert title of the book, you want to delete");
        bookShelve.printBooks();
        System.out.print("Title book: ");
        String titleBook = sc.next();

        for (Book book : bookShelve.getListBooks()){
            if(book.getTitle().equals(titleBook)){
                bookShelve.deleteBook(book);
                return;
            }
        }

    }

    public static void deleteBookShelve(){
        System.out.println("Insert code of the BookShelve");
        library.printBookShelves();
        System.out.print("Code bookshelve: ");
        String codeBookShelve = sc.next();

        for (BookShelve bookShelve : library.getListBookShelves()){
            if(bookShelve.getCode().equals(codeBookShelve)){
                library.removeBookShelves(bookShelve);
                return;
            }
        }
    }

    public static void listAllBooks() {
        for (BookShelve bookShelve : library.getListBookShelves()) {
            System.out.println("***********************************");
            System.out.println("BookShavle code: " + bookShelve.getCode() + ", type: " + bookShelve.getType());
            for (Book book : bookShelve.getListBooks()) {
                System.out.println("Book title: " + book.getTitle() + ", author: " + book.getAuthor() + ", editorial: " + book.getEditorial() + ", year: " + book.getYear());
            }
            System.out.println();
        }
    }


    //Database method
    public static void saveInDatabase() {
        DatabaseManager db = new DatabaseManager();
        for (BookShelve bookShelve : library.getListBookShelves()) {
            db.saveBookShelve(bookShelve.getCode(), bookShelve.getType());
            for (Book book : bookShelve.getListBooks()) {
                db.saveBook(book.getTitle(), book.getAuthor(), book.getYear(), book.getEditorial(), bookShelve.getCode());
            }
        }

    }

    //Database method
    public static void showLibrary(){
        DatabaseManager db = new DatabaseManager();
        db.showLibrary();
    }
}