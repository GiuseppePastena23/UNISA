package GestoreStudenti;

import GestoreStudenti.Studenti.Studenti;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.print.event.PrintEvent;
import javax.security.sasl.SaslException;



public class GestoreStudenti
{
    private static List<Studenti> ListaStudenti = new ArrayList<>();

    public static void addStudente(Studenti Studente)
    {
        ListaStudenti.add(Studente);
    }

    public static  List<Studenti> OrdinaPerEta()
    {
        List<Studenti> ListaStudentiOrdinati = ListaStudenti.stream()
        .sorted
        (
            (Studente1, Studente2) -> Integer.compare(Studente1.getEta(), Studente2.getEta())
        )
        .collect(Collectors.toList());

        return ListaStudentiOrdinati;
    }

    public static List<Studenti> getFuoriCorso()
    {
        List<Studenti> ListaStudentiFuoriCorso = ListaStudenti.stream()
        .filter(ListaStudenti -> ListaStudenti.getCategoria() == Studenti.Categoria.FUORI_CORSO)
        .collect(Collectors.toList());

        return ListaStudentiFuoriCorso;
    }

    public static void process(Predicate<Studenti> filtro, Consumer<Studenti> operation) 
    {
        ListaStudenti.stream().filter(filtro).forEach(operation);
    }

    public static List<Studenti> getLimit30(Boolean Maggiore30)
    {
        Predicate<Studenti> Limit30Predicate = student -> Maggiore30 ? student.getEta() > 30 : student.getEta() < 30;
        Consumer<Studenti> OperazioneAdd30 = student -> ListaStudenti.add(student);
        List<Studenti> over30 = new ArrayList<>();

        process(Limit30Predicate, OperazioneAdd30);

        return over30;
    }

    public static void SalvaFile(String FilePath) throws SalvataggioControllatoException
    {
        try
        { 
            PrintWriter SalvaStudenti = new PrintWriter(FilePath);
            SalvaStudenti.println(ListaStudenti);
            SalvaStudenti.close();
        }
        catch(IOException e)
        {
            throw new SalvataggioControllatoException("Errore I/O");
        }
    }

    

    

    
}