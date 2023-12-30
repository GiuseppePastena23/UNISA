import java.util.ArrayList;

public class Lavastoviglie implements Elettrodomestico {
    String marca;
    String nome;
    boolean back;
    int programmaAttuale;
    int contatoreLavaggi;
    ArrayList<String> programmiLavaggio;

    public Lavastoviglie() {
        programmaAttuale = 1;
        programmiLavaggio.add("Standard");
    }

    @Override
    public void start() {
        contatoreLavaggi++;
        return;
    }

    @Override
    public void next() {
        if ( programmiLavaggio.size() == 0)
            return;
        if ( programmiLavaggio.size() == 1 ){
            programmaAttuale = 1;
            return;
        }

        if ( programmaAttuale >= programmiLavaggio.size()){
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
        programmiLavaggio.add(nomeProgramma);
    }
    
}
