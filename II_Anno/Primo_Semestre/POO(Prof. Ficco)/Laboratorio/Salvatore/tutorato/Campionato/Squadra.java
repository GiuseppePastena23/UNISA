package core;

import java.util.List;

public class Squadra 
{
    private List<Calciatori> ListaCalciatori;
    private String Nome;
    private int ScudettiVinti;

    public int getScudettiVinti() {
        return ScudettiVinti;
    }




    public void setScudettiVinti(int scudettiVinti) {
        ScudettiVinti = scudettiVinti;
    }




    public Squadra(String nome, int scudettiVinti)
    {
        Nome = nome;
        ScudettiVinti = scudettiVinti;
    }

    


    public void printCalciatoreByNumero(int NumeroMaglia)
    {
        ListaCalciatori.stream()
        .filter(c1 -> c1.getNumeroMaglia() == NumeroMaglia)
        .forEach(System.out::println);
    }

    public List<Calciatori> getListaCalciatori() 
    {
        return ListaCalciatori;
    }
    public void setListaCalciatori(List<Calciatori> listaCalciatori) 
    {
        ListaCalciatori = listaCalciatori;
    }
    public void addCalciatore (Calciatori calciatore)
    {
        ListaCalciatori.add(calciatore);
    }
    public void removeCalciatore (Calciatori calciatore)
    {
        ListaCalciatori.remove(calciatore);
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public Squadra(List<Calciatori> listaCalciatori, String nome) 
    {
        ListaCalciatori = listaCalciatori;
        Nome = nome;
    }
    @Override
    public String toString() {
        return "Squadra [ListaCalciatori=" + ListaCalciatori + ", Nome=" + Nome + "]";
    }
}
