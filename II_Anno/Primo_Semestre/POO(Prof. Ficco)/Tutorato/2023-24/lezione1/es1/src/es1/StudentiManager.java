package es1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentiManager implements Manager {
    public List<Studente> studenti;

    public StudentiManager() {
        studenti = new ArrayList<Studente>();
    }

    public void add(Studente s) {
        studenti.add(s);
    }

    public void remove(Studente s) {
        studenti.remove(s);
    }

    public List<Studente> getStudentiByEsame(Esame e) {
        List<Studente> res = new ArrayList<Studente>();
        for (Studente s : studenti) {
            if (s.haSuperato(e)) {
                res.add(s);
            }
        }
        return res;
    }

    public void printInfoDSA() {
        for (Studente s : studenti) {
            if (s instanceof StudenteDSA) {
                System.out.println(s);
            }
        }
    }

    public List<StudenteDSA> getStudentByPatology(Patologia p) {
        List<StudenteDSA> res = new ArrayList<StudenteDSA>();
        for (Studente s : studenti) {
            if (s instanceof StudenteDSA) {
                if (((StudenteDSA) s).getPatologia() == p) {
                    res.add((StudenteDSA) s);
                }
            }
        }
        return res;
    }

    public Studente getStudentByIndex(int index) {
        return studenti.get(index);
    }

    public void printToFile(String pathStudents, String pathDSA) {
        PrintWriter osStudenti, osDSA;
        try {
            osStudenti = new PrintWriter(new FileWriter(pathStudents));
            osDSA = new PrintWriter(new FileWriter(pathDSA));
        } catch (IOException e) {
            System.err.println("Impossibile scrivere su file " + e);
            return;
        }

        for (Studente s : studenti) {
            if (s instanceof StudenteDSA) {
                osDSA.println(s);
            } else {
                osStudenti.println(s);
            }
        }
        osStudenti.close();
        osDSA.close();
    }

    public void clear() {
        studenti.clear();
    }
}
