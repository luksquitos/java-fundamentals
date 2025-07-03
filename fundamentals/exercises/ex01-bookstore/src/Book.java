import java.time.LocalDate;
import java.util.Random;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private LocalDate datePublished;
    private boolean isAvailable;

    public Book(String title, String author, LocalDate datePublished){
        this.isbn = "1";
        this.title = title;
        this.author = author;
        this.datePublished = datePublished;
        this.isAvailable = true;
    }

    public String getIsbn(){
        return this.isbn;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
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

    public boolean getIsAvailable(){
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString(){
        return this.getTitle() + "@" + this.getIsbn();
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
