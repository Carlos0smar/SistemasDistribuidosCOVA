import cova.assingment.secondexercise.Book;
import cova.assingment.secondexercise.BookShelve;
import cova.assingment.secondexercise.Library;
import cova.assingment.secondexercise.TypeBookShelves;
import cova.assingment.thirdexercise.DatabaseManager;
import cova.assingment.thirdexercise.MySqlConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LibrarySystemTests {
    @Test
    public void testCreateBookShelve() {
        Library library = new Library("Library", 100.0);
        library.addBookShelves(new BookShelve(TypeBookShelves.Metallic, "A"));
        library.addBookShelves(new BookShelve(TypeBookShelves.Wooden, "B"));

        Assertions.assertEquals("Metallic", library.getListBookShelves().get(0).getType().name());
        Assertions.assertEquals("Wooden", library.getListBookShelves().get(1).getType().name());


        Assertions.assertEquals("A", library.getListBookShelves().get(0).getCode());
        Assertions.assertEquals("B", library.getListBookShelves().get(1).getCode());

    }

    @Test
    public void testCreateABook() {
        Library library = new Library("Library", 100.0);
        library.addBookShelves(new BookShelve(TypeBookShelves.Metallic, "A"));
        library.addBookShelves(new BookShelve(TypeBookShelves.Wooden, "B"));

        library.getBookShelve("A").addBook(new Book("Book1", "Author1", "Editorial1", 2021));
        library.getBookShelve("A").addBook(new Book("Book2", "Author2", "Editorial2", 2022));
        library.getBookShelve("B").addBook(new Book("Book3", "Author3", "Editorial3", 2023));
        library.getBookShelve("B").addBook(new Book("Book4", "Author4", "Editorial4", 2024));

        Assertions.assertEquals("Book1", library.getBookShelve("A").getListBooks().get(0).getTitle());
        Assertions.assertEquals("Book2", library.getBookShelve("A").getListBooks().get(1).getTitle());
        Assertions.assertEquals("Book3", library.getBookShelve("B").getListBooks().get(0).getTitle());
        Assertions.assertEquals("Book4", library.getBookShelve("B").getListBooks().get(1).getTitle());
    }

    @Test
    public void testOnInsertingBookInBookShelve() {
        Library library = new Library("Library", 100.0);
        library.addBookShelves(new BookShelve(TypeBookShelves.Metallic, "A"));
        library.addBookShelves(new BookShelve(TypeBookShelves.Wooden, "B"));

        library.getBookShelve("A").addBook(new Book("Book1", "Author1", "Editorial1", 2021));
        library.getBookShelve("A").addBook(new Book("Book2", "Author2", "Editorial2", 2022));
        library.getBookShelve("B").addBook(new Book("Book3", "Author3", "Editorial3", 2023));
        library.getBookShelve("B").addBook(new Book("Book4", "Author4", "Editorial4", 2024));

        Assertions.assertEquals("Book1", library.getBookShelve("A").getListBooks().get(0).getTitle());
        Assertions.assertEquals("Book2", library.getBookShelve("A").getListBooks().get(1).getTitle());
        Assertions.assertEquals("Book3", library.getBookShelve("B").getListBooks().get(0).getTitle());
    }

}
