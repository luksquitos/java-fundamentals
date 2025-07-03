import java.time.LocalDate;
import java.util.Random;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private LocalDate datePublished;
    private int quantityAvailable;

    public Book(String title, String author, LocalDate datePublished, int quantityAvailable){
        this.isbn = this.generateIsbn(13);
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

    private String generateIsbn(int numberStrings){
        // Function to be used in populate isbn attribute.
        String characters = "1234567890";
        Random rand = new Random();
        StringBuilder stringGenerated = new StringBuilder();

        for(int i = 0; i <= numberStrings; i++){
            // Adding to StringBuilder instance a random string of characters.
            stringGenerated.append(characters.charAt(rand.nextInt(characters.length())));
        }

        return stringGenerated.toString();
    }
}
