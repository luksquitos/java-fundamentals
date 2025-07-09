import java.time.LocalDate;


public class Main {
    public static void main(String[] args) throws Exception{
        Book hailMary = new Book("Hail Mary", "Grisha", LocalDate.of(2015, 2, 11));
        Book hailMary2 = new Book("Hail Mary2", "Grisha", LocalDate.of(2015, 2, 11));
        Book theBookThief = new Book("The Book Thief", "Marcos Zusak", LocalDate.of(2011, 5, 9));

        Library library = new Library();
        library.addBook(hailMary);
        library.addBook(hailMary2);
        library.addBook(theBookThief);
        System.out.println(library.listAllBooks());

        library.borrowBook("1");
    }
}