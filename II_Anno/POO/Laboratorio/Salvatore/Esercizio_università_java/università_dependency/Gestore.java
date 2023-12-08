//creazione Package (anche se a singolo file)

//import List e Arraylist
import java.util.ArrayList;
import java.util.List;

//import Sottoclassi
import università.Esame;
import università.Studente;
import università.Studente_DSA;

//import gestione Files
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Gestore 
{   
    //la classe gestore implementa una sola lista studenti e una sola lista studentiDSA in quanto non avrebbe senso averne multiple.

    //creazione lista tutti studenti istituto
    private static List<Studente> Studenti = new ArrayList<Studente>();

    //get studente a posizione fissata
    Studente getStudente_pos(int pos)
    {
        if(pos >= 0 && pos < Studenti.size())
        {
            return Studenti.get(pos);
        }
        else{java.out.println("Errore indice");}
    }
    //set studente a posizione fissata
    void setStudente_pos(Studente studente, int pos)
    {
        if(pos >= 0 && pos < Studenti.size())
        {
            Studenti.set(pos, studente);
        }
        else{java.out.println("Errore indice");}
    }

    //get all studenti
    Studente getStudenti(){return Studenti;}

    //aggiunti studente nel primo posto libero lista
    void set_Studenti(Studente studente){Studenti.add(Studente);}


    //restituisce tutti gli studenti che hanno l'esame e in curriculum.
    public List<Studente> getStudentiByEsame(Esame esame) 
    {
        List<Studente> Studenti_con_esame = new ArrayList<>();
        for(int i = 0; i < Studenti.size(); i++)
        {
            Studente studente_corrente = Studenti.get(i);
            for(int j = 0; j < studente_corrente.getEsamiSuperati().size; j++)
            {
                if(studente_corrente.getEsameSuperatoPos(j).equal(esame))
                {
                    Studenti_con_esame.add(studente_corrente);
                }
                //else do nothing
            }
        }
        return Studenti_con_esame; //dovrebbe restituire una collection
    }

    //stampa a schermo tutti gli studenti DSA
    public void infoDSA()
    {
        system.out.println(StudentiDSA);
    }

    
    //restituisce un ArrayList di studenti DSA
    public List<Studente_DSA> getStudentiDSA()
    {
        List<Studente_DSA> StudentiDSA = new ArrayList<>();
        for(int i = 0; i < Studenti.size(); i++) //cicla tutti gli studenti
        {
            if(Studenti.getStudente_pos(i) instanceof Studente_DSA) //trova DSA e stampa
            {
                StudentiDSA.add(Studenti.getStudente_pos(i));
            }
            //else do nothing
        }      
        return StudentiDSA;
    }

    //restituisce un arraylist di studenti DSA con la stessa DSA
    public List<Studente_DSA> getStudentiDSA_Uguale()
    {
        List<Studente_DSA> StudentiDSA_Uguali = new ArrayList<>();
        for(int i = 0; i < getStudentiDSA.size(); i++)
        {
            for(int j = 0; i < getStudentiDSA.size(); j++)
            {
                if(getStudentiDSA().get(i).getDSA().equals(getStudentiDSA().get(j).getDSA()));
                {
                    StudentiDSA_Uguali.add(getStudentiDSA().get(i));
                }
                j--;
            }
        }
        return Studenti_DSA_Uguali;
    }

    //funzione salva su file .txt studenti
    public static void SalvaStudenti(String filePath)
    {
        try (BufferedWriter writerStudente = new BufferedWriter(new FileWriter(filePath))) 
        {
            // Write the information to the file
            for(Studente studente : Studenti) //for ma più ganzo
            {
                writerStudente.write("Nome: " + studente.getNome());
                writerStudente.newLine();
                writerStudente.write("Cognome: " + studente.getCognome());
                writerStudente.newLine();
                writerStudente.write("Datnas: " + studente.getDatnas());
                writerStudente.newLine();
                writerStudente.write("Codfis: " + studente.getCodfis());
                writerStudente.newLine();

                if(Studente instanceof Studente_DSA )
                {
                    writerStudente.write("DSA " + studente.getDSA());
                    writerStudente.newLine();
                }

            }

            System.out.println("Informazioni salvate in: " + filePath);
        } 
        catch (IOException exception) 
        {
            System.out.println(expection);
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
