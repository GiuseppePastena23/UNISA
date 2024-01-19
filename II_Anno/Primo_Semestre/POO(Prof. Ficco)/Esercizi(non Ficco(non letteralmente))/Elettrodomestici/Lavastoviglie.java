import java.util.ArrayList;

public class Lavastoviglie implements Elettrodomestico {
    String marca;
    String nome;
    boolean back;
    int programmaAttuale;
    int contatoreLavaggi;
    ArrayList<String> programmiLavaggio;

    public Lavastoviglie(String marca, String nome) {
        this.marca = marca;
        this.nome = nome;
        programmaAttuale = -1;
        programmiLavaggio = new ArrayList<>();
        contatoreLavaggi = 0;
        back = false;
    }

    @Override
    public String start() {
        if (programmaAttuale == -1)
            return "Nessun Programma selezionato\n" ;
        contatoreLavaggi++;
        return "Eseguo programma: " + programmiLavaggio.get(programmaAttuale) + "\n";
    }

    @Override
    public String next() {
        setNextProgramma();
        // Se non ci sono programmi
        if(programmaAttuale == -1)
            return "Nessun Programma selezionabile\n";
        return "Programma Selezionato: " + programmiLavaggio.get(programmaAttuale) + "\n";
    }
    /**
     * Imposta il programma attuale selezionato
     */
    private void setNextProgramma() {
        if (programmiLavaggio.size() == 0) {
            programmaAttuale = -1;
            return;
        }

        if (programmiLavaggio.size() == 1) {
            programmaAttuale = 1;
            return;
        } 
        // Se il programma attuale e' l'ultimo, torna indietro
        if ( programmaAttuale >= programmiLavaggio.size() - 1 ) {
            back = true;
            programmaAttuale--;
        } else if (back && programmaAttuale > 1) {
            programmaAttuale--;
        } else {
            back = false;
            programmaAttuale++;
        }
        return;
    }

    public void addProgrammaLavaggio(String nomeProgramma) {
        this.programmiLavaggio.add(nomeProgramma);
    }
    
}
