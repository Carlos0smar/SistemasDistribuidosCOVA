package cova.assingment.secondexercise;

public class Book {
    String title;
    String author;
    String editorial;
    int year;

    public Book(String title, String author, String editorial, int year) {
        this.title = title;
        this.author = author;
        this.editorial = editorial;
        this.year = year;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
