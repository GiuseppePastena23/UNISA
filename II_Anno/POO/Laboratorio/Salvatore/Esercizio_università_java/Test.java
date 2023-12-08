//import List e Arraylist
import java.util.ArrayList;
import java.util.List;

//import Sottoclassi
import università_dependency.università.Esame;
import università_dependency.università.Studente;
import università_dependency.università.Studente_DSA;
import università_dependency.Gestore;

public class Test 
{
    public static void main(String[] args)
    {
        Studente Studente17275 = new studente("Salvatore", "Conte", "14/07/2003", "CNTSVT03L14H805", "Autismo");
        Studente Studente17276 = new studente("Pasquale", "Muraca", "11/05/2003", "SPQMRC03M11H805");
        System.out.println(Studente17275);
        System.out.println(Studente17276);
        set_Studenti(Studente17275);
        set_Studenti(Studente17276);
        SalvaStudenti("Studenti.txt");
    }
}
