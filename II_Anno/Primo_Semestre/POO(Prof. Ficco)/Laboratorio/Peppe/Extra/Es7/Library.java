import java.util.ArrayList;

public class Library {
    ArrayList<Book> books;
    public Library()
    {
        books = new ArrayList<>();
    }

    public void addBook(Book book)
    {
        this.books.add(book);
    }

    public void removeBook()
    {
        this.books.remove(books.size() - 1);
    }

    @Override
    public String toString()
    {   
        int i = 1;
        StringBuilder res = new StringBuilder();
        for(Book book: this.books)
        {  
            res.append("Book " + i + "\n" + book + "\n");
            i++;
        }
        return res.toString();
    }
}
