import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Library {
    private List<Book> books = new ArrayList<>();

    public List<Book> listAllBooks(){
        return this.books;
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public List<Book> searchBooksByTitle(String title){
        return this.books
                .stream()
                .filter(book -> book.getTitle().contains(title))
                .toList();
    }

    public List<Book> searchBooksByAuthor(String author){
        return this.books
                .stream()
                .filter(book -> book.getAuthor().contains(author))
                .toList();
    }

    public Book getBookByIsbn(String isbn){
        return this.books
                .stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .toList()
                .getFirst();
    }

    public void borrowBook(String isbn) throws BookAlreadyBorrowedException {
        Book wishedBook = this.getBookByIsbn(isbn);
        if(!wishedBook.getIsAvailable()){
            throw new BookAlreadyBorrowedException("This book is already borrowed");
        }
        wishedBook.setIsAvailable(false);
    }

    public void returnBook(String isbn) throws BookAvailableException {
        Book bookToReturn = this.getBookByIsbn(isbn);
        if(bookToReturn.getIsAvailable()){
            throw new BookAvailableException("The book is not borrowed");
        }

        bookToReturn.setIsAvailable(true);
    }

}
