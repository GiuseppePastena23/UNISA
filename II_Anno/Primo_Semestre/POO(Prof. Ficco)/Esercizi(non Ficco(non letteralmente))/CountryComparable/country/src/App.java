public class App {
    public static void main(String[] args) throws Exception {
        Country c1 = new Country("Salerno", 190);
        Country c2 = new Country("Napoli", 200);

        System.out.println(c1.compareTo(c2));
    }
}
