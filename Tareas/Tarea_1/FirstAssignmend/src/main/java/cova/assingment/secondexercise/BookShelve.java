package cova.assingment.secondexercise;

import java.util.ArrayList;

public class BookShelve {
    TypeBookShelves type;
    String code;
    ArrayList<Book> listBooks;

    public BookShelve(TypeBookShelves type, String code) {
        this.type = type;
        this.code = code;
        this.listBooks = new ArrayList<>();
    }

    public TypeBookShelves getType() {
        return type;
    }

    public void setType(TypeBookShelves type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Book> getListBooks() {
        return listBooks;
    }

    public void setListBooks(ArrayList<Book> listBooks) {
        this.listBooks = listBooks;
    }

    public void printBooks(){
        System.out.println("Books");
        for (Book book : listBooks){
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Editorial: " + book.getEditorial() + ", Year: " + book.getYear());
        }
    }

    public void addBook(Book book) {
        listBooks.add(book);
    }

    public void deleteBook(Book book) {
        listBooks.remove(book);
    }
}