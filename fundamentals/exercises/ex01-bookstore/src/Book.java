import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private LocalDate datePublished;
    private int quantityAvailable;

    public Book(String title, String author, LocalDate datePublished, int quantityAvailable){
        this.isbn = UUID.randomUUID().toString();
        this.author = author;
        this.datePublished = datePublished;
        this.quantityAvailable = quantityAvailable;
    }

    public String getIsbn(){
        return this.isbn;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public LocalDate getDatePublished(){
        return this.datePublished;
    }

    public void setDatePublished(LocalDate datePublished){
        this.datePublished = datePublished;
    }

    public boolean isAvailable(){
        return this.quantityAvailable > 0;
    }
}
