import java.util.ArrayList;
import java.util.Scanner;



class Studente{
    private String name;
    private String matricola;
    public Studente(String name, String matricola){
        this.name = name;
        this.matricola = matricola;
    }

    public String getName() {
        return name;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }
}

class Segreteria{
    private String name;
    private String number;
    private ArrayList <Studente> studenti;
    public Segreteria(String name, String number){
        this.name = name;
        this.number = number;
        studenti = new ArrayList <Studente> ();
    }

    public String getName() {
        return name;
    }

    public void addStudente(Studente studente){
        studenti.add(studente);
    }

    public void delStudente(Studente studente){
        studenti.remove(studente);
    }

    public void stampaStudenti() {
        for (Studente studente : studenti) {
            System.out.println("Nome e Cognome: " + studente.getName() + " Matricola: " + studente.getMatricola() + "\n");
        }
    }
}

public class Array{
    public static void main(String[] args){
        Segreteria segreteria = new Segreteria("Informatica", "1");
        String nome;
        String matricola;
        Scanner scan = new Scanner(System.in);
    

   }
}
