import java.util.Random;

public class AziendaTest {
    String output;
    String[] nomiCasuali = {"Alessio", "Alessandro", "Barbara", "Chiara", "Carmelo", "Carmine", "Costanzo", "Davide", "Elio", "Francesca", "Giovanna"};
    String[] cognomiCasuali = {"Rossi", "Bianchi"};
    
    public AziendaTest() {
        output = "";
        Random rnd = new Random();
        for (int i = 0; i < 20; i++) {
            String nomeCasuale =  nomiCasuali[rnd.nextInt(nomiCasuali.length)];
            String cognomeCasuale = cognomiCasuali[rnd.nextInt(cognomiCasuali.length)];
            double pagaCasuale = rnd.nextInt(10) + 10;
            if(rnd.nextInt(2) == 0){
                DipendenteFisso dipFisso = new DipendenteFisso(nomeCasuale, cognomeCasuale, pagaCasuale);
                output += "Fisso " +  nomeCasuale + " " + dipFisso.nome + "\nPaga: " + pagaCasuale + " Ore: 40 Result: " + dipFisso.PagaSettimanale() + "\n";
                assert dipFisso.nome == nomeCasuale;
                assert dipFisso.PagaSettimanale() == pagaCasuale * 40;
            } else {
                DipendenteCottimo dipOrario = new DipendenteCottimo(nomeCasuale, cognomeCasuale, pagaCasuale);
                int oreRandom = rnd.nextInt(50) + 10;
                double paga = 0;
                if(oreRandom > 40)
                     paga = (40 * pagaCasuale) + (oreRandom - 40) * pagaCasuale * 1.5;
                dipOrario.setOreDiLavoro(oreRandom);
                output += "Cottimo " + nomeCasuale + " " + dipOrario.nome + "\nPaga: " + pagaCasuale + " Ore: " + oreRandom + " Result: " + dipOrario.PagaSettimanale() + "\n";
                assert dipOrario.nome == nomeCasuale;
                assert dipOrario.cognome == cognomeCasuale;
                assert dipOrario.PagaSettimanale() == paga;
            }
            output += "\n";
        }
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return output;
    }
}
  