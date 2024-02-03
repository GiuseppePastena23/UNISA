public class Main {
    public static void main(String[] args) {
        final int MAX_STUDENTS = 100;

        Segreteria segreteria = new Segreteria("informatica", "1234", MAX_STUDENTS);
        Studente studente1 = new Studente("Aldo", "Baglio", "001");
        Studente studente2 = new Studente("Giovanni", "Storti", "002");
        Studente studente3 = new Studente("Giacomo", "Poretti", "003");

        segreteria.registraStudente(studente1);
        segreteria.registraStudente(studente2);
        segreteria.registraStudente(studente3);

        segreteria.removeStudente(4);

        segreteria.printAllStudent();

    }
}