package es1;

import java.util.List;

public interface Manager {
    public List<Studente> getStudentiByEsame(Esame e);
    public void printInfoDSA();
    public List<StudenteDSA> getStudentByPatology(Patologia p);
    public void printToFile(String pathStudents, String pathDSA);
}
