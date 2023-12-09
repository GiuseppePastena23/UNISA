//creazione Package (anche se a singolo file)
package universita;

//import List e Arraylist
import java.util.ArrayList;
import java.util.List;

//import gestione Files
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Gestore 
{   
    //la classe gestore implementa una sola lista studenti e una sola lista studentiDSA in quanto non avrebbe senso averne multiple.

    //creazione lista tutti studenti istituto
    private static List<Studente> Studenti = new ArrayList<Studente>();

    //get studente a posizione fissata
    public static Studente getStudente_pos(int pos)
    {
        if(pos >= 0 && pos < Studenti.size())
        {
            return Studenti.get(pos);
        }
        else
        {
            System.out.println("Errore indice");
            return null;
        }
    }
    //set studente a posizione fissata
    public static void setStudente_pos(Studente studente, int pos)
    {
        if(pos >= 0 && pos < Studenti.size())
        {
            Studenti.set(pos, studente);
        }
        else{System.out.println("Errore indice");}
    }



    //get all studenti
    public static List<Studente> getStudenti(){return Studenti;}

    //aggiunti studente nel primo posto libero lista
    public static void set_Studenti(Studente studente)
    {
        Studenti.add(studente);
    }


    //restituisce tutti gli studenti che hanno l'esame e in curriculum.
    public static List<Studente> getStudentiByEsame(Esame esame) 
    {
        List<Studente> Studenti_con_esame = new ArrayList<>();
        for(int i = 0; i < Studenti.size(); i++)
        {
            Studente studente_corrente = getStudente_pos(i);
            for(int j = 0; j < studente_corrente.getEsamiSuperati().size(); j++)
            {
                if(esame.equals(studente_corrente.getEsameSuperatoPos(j)))
                {
                    Studenti_con_esame.add(studente_corrente);
                }
                //else do nothing
            }
        }
        return Studenti_con_esame; //dovrebbe restituire una collection
    }

    //creo studentiDSA
    private static List<Studente_DSA> StudentiDSA = new ArrayList<>();
    //inizializzo e riempo StudentiDSA
    static{
        for (Studente studente : Studenti) 
        {
         // Check if the current student is an instance of Studente_DSA
            if (studente instanceof Studente_DSA) 
            {
               Studente_DSA studenteDSA = (Studente_DSA)studente;
               StudentiDSA.add(studenteDSA);
            }
        }
    }

    public static Studente_DSA getStudenteDSA_pos(int pos)
    {
        if(pos >= 0 && pos < StudentiDSA.size())
        {
            return StudentiDSA.get(pos);
        }
        else
        {
            System.out.println("Errore indice");
            return null;
        }
    }    
    
    public static void setStudenteDSA_pos(Studente_DSA studente, int pos)
    {
        if(pos >= 0 && pos < StudentiDSA.size())
        {
            Studenti.set(pos, studente);
        }
        else{System.out.println("Errore indice");}
    }

    //restituisce un arraylist di studenti DSA con la stessa DSA
    private static List<Studente_DSA> StudentiDSA_Uguali = new ArrayList<>();
    static
    {
        for(int i = 0; i < StudentiDSA.size(); i++)
        {
            for(int j = 0; i < StudentiDSA.size(); j++)
            {
                if(StudentiDSA.get(j).getDSA().equals(StudentiDSA.get(j).getDSA()));
                {
                    StudentiDSA_Uguali.add(StudentiDSA.get(i));
                }
                j--;
            }
        }
    }

    public static List<Studente_DSA> getStudentiDSA_Uguale()
    {
        return StudentiDSA_Uguali;
    }

    //stampa a schermo tutti gli studenti DSA
    public static void infoDSA()
    {
        System.out.println(StudentiDSA);
    }

    //funzione salva su file .txt studenti
    public static void SalvaStudenti(String filePath)
    {
        PrintWriter writerStudente; 
        try
        {
            writerStudente = new PrintWriter(new FileWriter(filePath));
            // Write the information to the file
            for(Studente studente : Studenti) //for ma più ganzo
            {
                writerStudente.println("Nome: " + studente.getNome());
                writerStudente.println("Cognome: " + studente.getCognome());
                writerStudente.println("Datnas: " + studente.getDatnas());
                writerStudente.println("Codfis: " + studente.getCodfis());

                if(studente instanceof Studente_DSA)
                {
                    Studente_DSA studenteDSA = (Studente_DSA)studente;
                    writerStudente.println("DSA " + studenteDSA.getDSA());
                }

            }
            writerStudente.close();

            System.out.println("Informazioni salvate in: " + filePath);
        } 
        catch (IOException exception) 
        {
            System.out.println(exception);
        }
    }

    /* 
    //funzione salva su file .txt studentiDSA
    public static void SalvaStudentiDSA(String filePath)
    {
        try (BufferedWriter writerStudente = new BufferedWriter(new FileWriter(filePath))) 
        {
            // Write the information to the file
            writer.write("Nome: " + student.getNome());
            writer.newLine();
            writer.write("Cognome: " + student.getCognome());
            writer.newLine();
            writer.write("Datnas: " + student.getDatnas());
            writer.newLine();
            writer.write("Codfis: " + student.getCodfis());
            writer.newLine();
            writer.write("DSA: " + student.getDSA());
            writer.newLine();

            System.out.println("Informazioni salvate in: " + filePath);
        } 
        catch (IOException exception) 
        {
            exception.printStackTrace();
        }
    }
    */
}
