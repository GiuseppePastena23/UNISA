package GestoreStudenti;

import GestoreStudenti.Studenti.Studenti;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GestoreStudenti
{
    private static List<Studenti> ListaStudenti = new ArrayList<>();

    public void addStudente(Studenti Studente)
    {
        ListaStudenti.add(Studente);
    }

    public List<Studenti> OrdinaPerEta()
    {
        List<Studenti> ListaStudentiOrdinati = ListaStudenti.stream()
        .sorted
        (
            (Studente1, Studente2) -> Integer.compare(Studente1.getEta(), Studente2.getEta())
        )
        .collect(Collectors.toList());

        return ListaStudentiOrdinati;
    }

    public List<Studenti> getFuoriCorso()
    {
        List<Studenti> ListaStudentiFuoriCorso = ListaStudenti.stream()
        .filter(ListaStudenti -> ListaStudenti.getCategoria() == Studenti.Categoria.FUORI_CORSO)
        .collect(Collectors.toList());

        return ListaStudentiFuoriCorso;
    }

}