import java.math.BigInteger;

public class Book {
    String name;
    String author;
    int numOfPages;

    public Book(String name, String author, int numOfPages)
    {
        this.name = name;
        this.author = author;
        this.numOfPages = numOfPages;
    }

    @Override
    public String toString()
    {
        return "Name: " + this.name + "\nAuthor: " + this.author + "\nNumber of pages: " + this.numOfPages; 
    }
}
