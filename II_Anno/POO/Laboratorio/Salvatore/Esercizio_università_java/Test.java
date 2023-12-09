//import List e Arraylist
import java.util.ArrayList;
import java.util.List;

//import Sottoclassi
import università.*;

public class Test 
{
    public static void main(String[] args)
    {
        Studente_DSA Studente17275 = new Studente_DSA("Salvatore", "Conte", "14/07/2003", "CNTSVT03L14H805", "Autismo");
        Studente Studente17276 = new Studente("Pasquale", "Muraca", "11/05/2003", "PSQMRC03M11H805");
        System.out.println(Studente17275);
        System.out.println(Studente17276);
        Gestore.set_Studenti(Studente17275);
        Gestore.set_Studenti(Studente17276);
        Gestore.SalvaStudenti("Studenti.txt");
    }
}
