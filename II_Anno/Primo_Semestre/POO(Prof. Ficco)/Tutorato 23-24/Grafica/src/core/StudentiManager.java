package core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentiManager {
    private static final List<Studente> studenti = new ArrayList<>();


    public static void addStudente(Studente studente) {
        studenti.add(studente);
    }

    public static void addStudente(String nome, String cognome, int eta, Categoria categoria) {
        addStudente(new Studente(nome, cognome, eta, categoria));
    }

    public static List<Studente> getStudenti() {
        return studenti;
    }


    public static void printOnFile() throws SalvataggioControllatoException {
        String filename = "studenti.txt";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(studenti);
        } catch (IOException e) {
            throw new SalvataggioControllatoException();
        }
    }

}
