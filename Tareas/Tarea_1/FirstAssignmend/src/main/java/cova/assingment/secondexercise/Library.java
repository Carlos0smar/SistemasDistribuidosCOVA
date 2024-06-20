package cova.assingment.secondexercise;

import java.util.ArrayList;

public class Library {

    String name;
    Double size;
    ArrayList<BookShelve> listBookShelves;

    public Library(String name, Double size) {
        this.name = name;
        this.size = size;
        this.listBookShelves = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public ArrayList<BookShelve> getListBookShelves() {
        return listBookShelves;
    }

    public void setListBookShelves(ArrayList<BookShelve> listBookShelves) {
        this.listBookShelves = listBookShelves;
    }

    public void addBookShelves(BookShelve bookShelve) {
        listBookShelves.add(bookShelve);
    }

    public void removeBookShelves(BookShelve bookShelve) {
        if (bookShelve.getListBooks().isEmpty()){
            listBookShelves.remove(bookShelve);
            return;
        }
        System.out.println("The BookShelve can't be deleted, because has books");
    }

    public void printBookShelves() {
        for (BookShelve bookShelve : listBookShelves) {
            System.out.println("BookShavle code: " + bookShelve.getCode() + ", type: " + bookShelve.getType());
        }
    }

    public BookShelve getBookShelve(String code){
        for(BookShelve bookShelve : listBookShelves){
            if(bookShelve.getCode().equals(code)){
                return bookShelve;
            }
        }
        return null;
    }

}
