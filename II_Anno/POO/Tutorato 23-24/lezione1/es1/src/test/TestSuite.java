package test;
import es1.*;

import java.util.Date;

public class TestSuite {

    public static void main(String[] args) {
        StudentiManager sm = new StudentiManager();
        Studente studente = new Studente("Mario", "Rossi", "MRORSS80A01H501R", "123456");
        StudenteDSA studenteDSA = new StudenteDSA("Luigi", "Verdi", "LGVVRD80A01H501R", "654321", Patologia.DISLESSIA);
        Esame esame = new Esame("Matematica", 6, 30, new Date());

        // Test addStudente
        sm.add(studente);
        assert sm.studenti.size() == 1 : "addStudente failed";
        assert sm.studenti.contains(studente) : "addStudente failed";

        // Test addStudenteDSA
        sm.add(studenteDSA);
        assert sm.studenti.size() == 2 : "addStudenteDSA failed";
        assert sm.studenti.contains(studenteDSA) : "addStudenteDSA failed";

        // Test removeStudente
        sm.remove(studente);
        assert sm.studenti.size() == 1 : "removeStudente failed";
        assert !sm.studenti.contains(studente) : "removeStudente failed";

        // Test getStudentiByEsame
        studente.esamiSuperati.add(esame);
        assert sm.getStudentiByEsame(esame).size() == 1 : "getStudentiByEsame failed";
        assert sm.getStudentiByEsame(esame).contains(studente) : "getStudentiByEsame failed";

        // Test getStudentByPatology
        assert sm.getStudentByPatology(Patologia.DISLESSIA).size() == 1 : "getStudentByPatology failed";
        assert sm.getStudentByPatology(Patologia.DISLESSIA).contains(studenteDSA) : "getStudentByPatology failed";

        // Test printToFile
        // aggiungo degli studenti e do alcuni esami
        sm.add(new Studente("Mario", "Rossi", "MRORSS80A01H501R", "123456"));
        sm.add(new Studente("Luigi", "Verdi", "LGVVRD80A01H501R", "654321"));
        sm.add(new Studente("Giovanni", "Bianchi", "GVNBNC80A01H501R", "789456"));
        sm.add(new Studente("Paolo", "Neri", "PLNLR80A01H501R", "987654"));
        sm.add(new StudenteDSA("Giuseppe", "Gialli", "GPPGLL80A01H501R", "159753", Patologia.DISLESSIA));
        sm.add(new StudenteDSA("Antonio", "Arancioni", "ANTARC80A01H501R", "357159", Patologia.DISLESSIA));
        sm.add(new Studente("Francesco", "Fucsia", "FRNFCS80A01H501R", "753159"));
        sm.add(new Studente("Giorgio", "Grigi", "GRGGRI80A01H501R", "951753"));
        sm.add(new Studente("Daniele", "Dorati", "DNDRTI80A01H501R", "357951"));
        sm.add(new Studente("Carlo", "Ciano", "CRLCNO80A01H501R", "159357"));
        sm.getStudentByIndex(0).superaEsame(new Esame("Analisi", 9, 18, new Date()));
        sm.getStudentByIndex(0).superaEsame(new Esame("Fisica", 9, 20, new Date()));
        sm.getStudentByIndex(1).superaEsame(new Esame("POO", 9, 31, new Date()));
        sm.getStudentByIndex(4).superaEsame(new Esame("P1", 9, 30, new Date()));
        sm.getStudentByIndex(4).superaEsame(new Esame("PSD", 9, 25, new Date()));
        sm.printToFile("studenti.txt", "studentiDSA.txt");


        // System.out.println("All tests passed.");
    }
}