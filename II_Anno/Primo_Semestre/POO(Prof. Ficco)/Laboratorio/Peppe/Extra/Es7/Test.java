public class Test {
    public static void main(String[] args) {
        Library library = new Library();
        Book book0 = new Book("Ciao", "Antonio", 75);
        Book book1 = new Book("Ciao", "Antonio", 75);
        Book book2 = new Book("Ciao", "Antonio", 75);
        library.addBook(book0);
        library.addBook(book1);
        library.addBook(book2);

        System.out.println(library);

        library.removeBook();

        System.out.println(library);
    }
}
